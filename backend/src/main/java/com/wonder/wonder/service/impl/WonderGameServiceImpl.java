package com.wonder.wonder.service.impl;

import com.wonder.wonder.cards.*;
import com.wonder.wonder.dto.BoardDto;
import com.wonder.wonder.dto.EventDto;
import com.wonder.wonder.dto.PayDto;
import com.wonder.wonder.dto.ResourceChooseDto;
import com.wonder.wonder.dto.conerter.GameBoardDtoConverter;
import com.wonder.wonder.model.*;
import com.wonder.wonder.phase.GamePhase;
import com.wonder.wonder.phase.UserActionOnCard;
import com.wonder.wonder.service.*;
import com.wonder.wonder.service.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by bm on 16.07.17.
 */
//@Scope(value = "request")
@Component
public class WonderGameServiceImpl implements WonderGameService {
    @Autowired
    private GameService gameService;
    @Autowired
    private EventService eventService;
    @Autowired
    private CardSetItemService cardSetItemService;
    @Autowired
    private CardSetService cardSetService;
    @Autowired
    private UserInGameService userInGameService;
    @Autowired
    private GameBoardDtoConverter gameBoardDtoConverter;
    @Autowired
    JmsTemplate jmsTemplate;

    private void saveEvent(Event currentEvent) {
        eventService.save(currentEvent);
    }

    @Override
    public void playCard(EventDto eventDto) {
        long userInGameId = eventDto.getUserInGameId();
        long gameId = eventDto.getGameId();
        UserInGame userInGame = userInGameService.getUserInGameByIdAndGameId(userInGameId, gameId);
        Game game = userInGame.getGame();
        List<GameUserInfo> gameUserInfos = new ArrayList<>(GameUserInfoUtils
                .createGameUserInfo(game.getEvents()).values());

        GameBoardView gameBoardView = new GameBoardView(game, eventDto.getUserInGameId(), gameUserInfos);
        GameUserInfo currentUserGameInfo = gameBoardView.getCurrentUserGameInfo();
        UserActionOnCard userActionOnCard = eventDto.getUserActionOnCard();
        GameCard targetCard = eventDto.getPlayOnCardForEvent();
        Event currentEvent = addInformationToEventForSave(currentUserGameInfo, eventDto);
        boolean isSellCard = userActionOnCard.equals(UserActionOnCard.SELL_CARD);
        if (isSellCard) {
            currentUserGameInfo.addGoldForSale();
        } else {
            GameCard chainCard = currentEvent.getChainCard();
            boolean isBuildChain = chainCard != null;
            exceptionForDuplicate(gameBoardView, chainCard);
            if (isBuildChain) {
                boolean chainIsCorrect = gameBoardView.getCurrentUserBuildCard().contains(chainCard)
                        && checkCorrectChain(targetCard, chainCard);
                if (chainIsCorrect) {
                    currentUserGameInfo.getEventToSave().setChainCard(chainCard);
                } else {
                    throw new RuntimeException("You no can build by chain");
                }
            }
            exeptionZeusPowerDeactivateWhenUserActionZeus(currentUserGameInfo, userActionOnCard);
            exceptionNoBuiltMausoleumForActionResurrect(game, currentUserGameInfo, userActionOnCard);

            exeptionBuildMoreLevelWonderThenMax(currentUserGameInfo);// bug
            //todo like with zeus
            if (GameUserInfoUtils.isBuild(userActionOnCard) || userActionOnCard.equals(UserActionOnCard.BUILD_WONDER)) {
                GameUserInfo leftUserInfo = gameBoardView.getLeftSiteUser();
                GameUserInfo rightUserInfo = gameBoardView.getRightSiteUser();
                List<BaseResource> resourcesNeed = targetCard.getResourcesNeedForBuild();
                List<ResourceChooseDto> resourceChooseDtos = eventDto.getResourceChooseDtoList();
                List<PayDto> payDtoList = eventDto.getPayDtoList();
                int goldNeedForConstruction = targetCard.getGoldNeededForConstruction();
                exeptionNoHaveEnoughtMoney(currentUserGameInfo, goldNeedForConstruction);
                payGoldForBuild(currentEvent, goldNeedForConstruction);
                boolean isCardNeedResourceForBuild = resourcesNeed.size() > 0;

                if (isCardNeedResourceForBuild) {
                    int userResourceSize = resourceChooseDtos.size();
                    int buyResourceSize = payDtoList.size();
                    exeptionUserNoChooseResourceForBuild(userResourceSize, buyResourceSize);
                    for (ResourceChooseDto chooseDto : resourceChooseDtos) {
                        List<BaseResource> baseResourcesChooseUser = new ArrayList<>(chooseDto.getResourceChoose());
                        GameResource cardGiveResource = chooseDto.getCard().getGiveResource();
                        exeptionChooseTwoResourseNeedOne(baseResourcesChooseUser, cardGiveResource);
                        exeptionChooseFailResourceInCard(baseResourcesChooseUser, cardGiveResource);
                        currentUserGameInfo.addResourcesForBuild(chooseDto.getResourceChoose());
                    }
                    // TODO ASK
                    changeTradeDiscountBrownLeftIsHaveTrade(currentUserGameInfo);// todo remove one field
                    changeTradeDiscountBrownRightIsHaveTrade(currentUserGameInfo);
                    changeTradeDiscountSilverIsHaveTrade(currentUserGameInfo);

                    //todo method pay
                    for (PayDto payDto : payDtoList) {
                        List<BaseResource> baseResourcesChooseUser = new ArrayList<>(payDto.getBuyResourceList());
                        GameResource cardGiveResourse = payDto.getGameCard().getGiveResource();
                        exeptionChooseTwoResourseNeedOne(baseResourcesChooseUser, cardGiveResourse);
                        exeptionChooseFailResourceInCard(baseResourcesChooseUser, cardGiveResourse);
                        ActionSide actionSide = payDto.getActionSide();
                        int needPayGold;
                        int buySilver = currentUserGameInfo.getBuySilver();
                        if (actionSide.equals(ActionSide.LEFT)) {
                            exeptionPlayerNoHaveThisCard(leftUserInfo, payDto, actionSide);
                            int buyBrownLeft = currentUserGameInfo.getBuyBrouwnLeft();
                            needPayGold = getAddGold(payDto, buySilver, buyBrownLeft);
                            leftUserInfo.addGoldToNewEvent(needPayGold);
                        } else if (actionSide.equals(ActionSide.RIGHT)) {
                            exeptionPlayerNoHaveThisCard(rightUserInfo, payDto, actionSide);
                            int buyBrownRight = currentUserGameInfo.getBuyBrouwnRight();
                            needPayGold = getAddGold(payDto, buySilver, buyBrownRight);
                            rightUserInfo.addGoldToNewEvent(needPayGold);
                        }
                        exceptionNotEnoughMoney(currentUserGameInfo, rightUserInfo, leftUserInfo);
                        currentUserGameInfo.addResourcesForBuild(payDto.getBuyResourceList());
                    }
                }
                exeptionNotEnoughtResourseForConstruct(currentUserGameInfo, resourcesNeed);
                saveEventIfNeedPay(leftUserInfo, ActionSide.RIGHT);
                saveEventIfNeedPay(rightUserInfo, ActionSide.LEFT);
            }
        }
        saveCardSetItem(eventDto.getCardSetId(), targetCard, game, userInGame);
        saveEvent(currentEvent);
        // Send a message with a POJO - the template reuse the message converter
        TransferEvent transferEvent = new TransferEvent(game.getId(), userInGame.getId(), game.getPhaseGame(),
                game.getPhaseRound(), game.getPhaseChooseDo());
        jmsTemplate.convertAndSend("transferEvent", transferEvent);

    }

    private void exceptionForDuplicate(GameBoardView gameBoardView, GameCard chainCard) {
        if (gameBoardView.getCurrentUserBuildCard().contains(chainCard))
            throw new RuntimeException("You want to build duplicate");
    }

    protected void changeTradeDiscountSilverIsHaveTrade(GameUserInfo currentUserGameInfo) {
        boolean isTradeSilverDiscountRightAndLeft = currentUserGameInfo.isTradeSilverRightAndLeft();
        if (isTradeSilverDiscountRightAndLeft) {
            currentUserGameInfo.changeBuySilverRightAndLeft();
        }
    }

    protected void changeTradeDiscountBrownRightIsHaveTrade(GameUserInfo currentUserGameInfo) {
        boolean isTradeDiscountBrownRight = currentUserGameInfo.isTradeBrownRight();
        if (isTradeDiscountBrownRight) {
            currentUserGameInfo.changeBuyBrouwnRight();
        }
    }

    protected void changeTradeDiscountBrownLeftIsHaveTrade(GameUserInfo currentUserGameInfo) {
        boolean isTradeDiscountBrownLeft = currentUserGameInfo.isTradeBrownLeft();
        if (isTradeDiscountBrownLeft) {
            currentUserGameInfo.changeCostBuyBrownLeft();
        }
    }

    protected void exeptionPlayerNoHaveThisCard(GameUserInfo gameUserInfo, PayDto payDto, ActionSide actionSide) {
        List<GameCard> userBuiltCards = gameUserInfo.getUserBuiltCards();
        GameCard chooseCardForBuyResource = payDto.getGameCard();
        boolean noHaveChooseCardRight = !userBuiltCards.contains(chooseCardForBuyResource);
        if (noHaveChooseCardRight) {
            throw new RuntimeException(actionSide.toString() + " player no have card whis this name" + payDto.getGameCard());
        }
    }

    private void saveCardSetItem(Long cardSetId, GameCard currentEventGameCard, Game game, UserInGame userInGame) {
        CardSet cardSet = cardSetService.findById(cardSetId);
        CardSetItem cardSetItem = cardSetItemService.findByCardSetAndGameCard(cardSet, currentEventGameCard);
        cardSetItem.setPlayedGamePhase(game.getPhaseGame());
        cardSetItem.setPlayedPhaseChooseDo(game.getPhaseChooseDo());
        cardSetItem.setPlayedPhaseRound(game.getPhaseRound());
        cardSetItem.setUserInGame(userInGame);
        cardSetItemService.save(cardSetItem);
    }

    protected void exeptionChooseTwoResourseNeedOne(List<BaseResource> baseResourcesChooseUser, GameResource cardGiveResource) {
        boolean shouldBeChosen = cardGiveResource.getShouldBeChosen();
        if (shouldBeChosen) {
            if (baseResourcesChooseUser.size() > 1) {
                throw new RuntimeException("You choose two resource where need choose one");
            }
        }
    }

    protected void exeptionChooseFailResourceInCard(List<BaseResource> baseResourcesChooseUser, GameResource cardGiveResource) {
        List<BaseResource> baseResourcesGiveCard = cardGiveResource.getResources();
        for (BaseResource recourseChoose : baseResourcesGiveCard) {
            if (!baseResourcesChooseUser.remove(recourseChoose)) {
                throw new RuntimeException("You choose resourse what not have card");
            }
        }
    }

    protected void saveEventIfNeedPay(GameUserInfo gameUserInfo, ActionSide actionSide) {
        boolean needPayGoldLeft = gameUserInfo.getEventToSave().getGoldChange() > 0;
        if (needPayGoldLeft) {
            gameUserInfo.getEventToSave().setFrom_user(actionSide);
            saveEvent(gameUserInfo.getEventToSave());
        }
    }

    protected void exeptionNotEnoughtResourseForConstruct(GameUserInfo currentUserGameInfo, List<BaseResource> resourcesNeed) {
        for (BaseResource resource : resourcesNeed) {
            if (!currentUserGameInfo.getAllResourceForBuild().remove(resource)) {
                throw new RuntimeException("Not have needed resourse for constuction(building)");
            }
        }
    }

    protected void exeptionNoHaveEnoughtMoney(GameUserInfo currentUserGameInfo, int goldNeedForConstuction) {
        int userGoldAfterEvent = currentUserGameInfo.getUserGold() - goldNeedForConstuction;
        boolean isNoHaveEnoughtMoney = userGoldAfterEvent < 0;
        if (isNoHaveEnoughtMoney) {
            throw new RuntimeException("You no have gold for constraction");
        }
    }

    protected void exeptionZeusPowerDeactivateWhenUserActionZeus(GameUserInfo currentUserGameInfo, UserActionOnCard userActionOnCard) {
        boolean zeusPassiveDeactivate = !currentUserGameInfo.isZeusPassiveWonderActive();
        if (userActionOnCard.isBuildZeus() && zeusPassiveDeactivate) {
            throw new RuntimeException("ZEUS power wonder is Deactivate");
        }
    }

    protected void exceptionNoBuiltMausoleumForActionResurrect(Game game, GameUserInfo currentUserGameInfo, UserActionOnCard userActionOnCard) {
        boolean isResurrectCard = isResurrectCard(userActionOnCard); //todo like with zeus
        if (isResurrectCard) {
            int gameRound = game.getPhaseRound();
            GamePhase gamePhase = game.getPhaseGame();
            boolean noBuildMavzoleumInThisRound = currentUserGameInfo.getRoundResurrectActivate() != gameRound;
            boolean noBuildMavzoleumInThisAge = currentUserGameInfo.getAgeResurrectActivate().equals(gamePhase);
            if (noBuildMavzoleumInThisRound || noBuildMavzoleumInThisAge) {
                throw new RuntimeException("You no Build Mausoleum Resurrect");
            }
        }
    }

    protected int getAddGold(PayDto payDto, int buySilver, int buyBrown) {
        List<BaseResource> buyResource = payDto.getBuyResourceList();
        GameCardColor cardColor = payDto.getGameCard().getGameCardColor();
        int addGold = 0;
        if (cardColor.equals(GameCardColor.BROWN)) {
            addGold = buyResource.size() * buyBrown;
        } else if (cardColor.equals(GameCardColor.SILVER)) {
            addGold = buyResource.size() * buySilver;
        }
        return addGold;
    }

    protected void exceptionNotEnoughMoney(GameUserInfo currentUserGameInfo, GameUserInfo rightUserInfo, GameUserInfo leftUserInfo) {
        int userGoldNow = currentUserGameInfo.getUserGold();
        int goldNeedPayLeft = leftUserInfo.getEventToSave().getGoldChange();
        int goldNeedPayRight = rightUserInfo.getEventToSave().getGoldChange();
        int needPayGold = goldNeedPayLeft + goldNeedPayRight;
        boolean haveNotEnoughtMoneyForPay = userGoldNow - needPayGold < 0;
        if (haveNotEnoughtMoneyForPay) {
            throw new RuntimeException("Need more gold more buying resourse");
        }
    }

    protected Event addInformationToEventForSave(GameUserInfo currentUserGameInfo, EventDto eventDto) {
        Event currentEvent = currentUserGameInfo.getEventToSave();
        currentEvent.setCard(eventDto.getPlayOnCardForEvent());
        currentEvent.setChainCard(eventDto.getChainCard());
        currentEvent.setUserActionOnCard(eventDto.getUserActionOnCard());
        currentEvent.setToPutOnForBuild(eventDto.getToPutOnForBuild());
        return currentEvent;

    }

    protected void exeptionUserNoChooseResourceForBuild(int userResourceSize, int buyResourceSize) {
        boolean isUserNoChooseResourceForBuild = userResourceSize == 0 & buyResourceSize == 0;
        if (isUserNoChooseResourceForBuild) {
            throw new RuntimeException("You no can build this card, no choose resource for build");
        }
    }

    protected void payGoldForBuild(Event currentEvent, int goldNeedForConstruction) {
        int minusGoldNeedForConstruction = -goldNeedForConstruction;
        currentEvent.setGoldChange(minusGoldNeedForConstruction);
    }

    protected boolean isResurrectCard(UserActionOnCard userActionOnCard) {
        return userActionOnCard.equals(UserActionOnCard.RESURRECT_CARD);
    }

    protected boolean checkCorrectChain(GameCard card, GameCard chainCard) {
        return card.getChain().stream().anyMatch(s -> s.equals(chainCard.name()));
    }

    protected void exeptionBuildMoreLevelWonderThenMax(GameUserInfo currentUserGameInfo) {
        int wonderLevel = currentUserGameInfo.getWonderLevel();
        int maxWonderLevel = currentUserGameInfo.getWonder().getWonderLevelCard().size();
        boolean isMoreLevelWonderThenMax = wonderLevel >= maxWonderLevel;
        if (isMoreLevelWonderThenMax) {
            throw new RuntimeException("You want build wonder Level more then max");
        }
    }

    @Override
    public BoardDto getCurrentBoard(Long gameId) {
        Game game = gameService.findGameById(gameId);
        return gameBoardDtoConverter.convertToDto(game);
    }
}





