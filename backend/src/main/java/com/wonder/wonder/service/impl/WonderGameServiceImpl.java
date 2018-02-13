package com.wonder.wonder.service.impl;

import com.wonder.wonder.cards.*;
import com.wonder.wonder.dto.BoardDto;
import com.wonder.wonder.dto.EventDto;
import com.wonder.wonder.dto.PayDto;
import com.wonder.wonder.dto.ResourceChooseDto;
import com.wonder.wonder.dto.conerter.GameBoardDtoConverter;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.UserInGame;
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
    private UserInGameService userInGameService;
    @Autowired
    private GameBoardDtoConverter gameBoardDtoConverter;
    @Autowired
    JmsTemplate jmsTemplate;
    private boolean moreLevelWonderThenMax;

    private void save(Event currentEvent) {
        eventService.save(currentEvent);
    }

    @Override
    public void playCard(EventDto eventDto) {
        long userInGameId = eventDto.getUserInGameId();
        long gameId = eventDto.getGameId();
        UserInGame userInGame = userInGameService.getUserInGameByIdAndGameId(userInGameId, gameId);
        Game game = userInGame.getGame();
// CALCULATE ALL NEED INFORMATION
        List<GameUserInfo> gameUserInfos = new ArrayList<>(GameUserInfoUtils
                .createGameUserInfo(game.getEvents()).values());

        GameBoardView gameBoardView = new GameBoardView(game, eventDto.getUserInGameId(), gameUserInfos);
        GameUserInfo currentUserGameInfo = gameBoardView.getCurrentUserGameInfo();

        Event currentEvent = currentUserGameInfo.getEventToSave();
        currentEvent.setCard(eventDto.getPlayOnCardForEvent());
        currentEvent.setChainCard(eventDto.getChainCard());
        currentEvent.setUserActionOnCard(eventDto.getUserActionOnCard());
        currentEvent.setToPutOnForBuild(eventDto.getToPutOnForBuild());

        UserActionOnCard userActionOnCard = currentEvent.getUserActionOnCard();
        GameCard currentEventGameCard = currentEvent.getCard();

        boolean isSellCard = userActionOnCard.equals(UserActionOnCard.SELL_CARD);
        if (isSellCard) {
            addGoldForSale(currentEvent);
        } else {
            GameCard chainCard = currentEvent.getChainCard();
            boolean isBuildChain = isBuildChain(chainCard);

            for (GameCard builtCard : gameBoardView.getCurrentUserBuildCard()) {
                boolean checkPossibilityToDublicate = builtCard.equals(currentEventGameCard);
                if (checkPossibilityToDublicate) {
                    exeptionForDublicate(userActionOnCard, currentEvent);
                }

                if (isBuildChain && checkCorrectChain(currentEventGameCard, chainCard) && builtCard.equals(chainCard)) {
                    addCanBuildByChain(currentUserGameInfo);
                }
            }

            boolean noCanBuildByChain = !currentUserGameInfo.isCanBuildByChainCurrentCard();
            if (isBuildChain && noCanBuildByChain) {
                throw new RuntimeException("You no can build by chain");
            }

            boolean isBuildZeus = GameUserInfoUtils.isBuildZeus(userActionOnCard);
            boolean zeusPassiveWasUse = !currentUserGameInfo.isZeusPassiveWonderActive();
            if (isBuildZeus && zeusPassiveWasUse) {
                throw new RuntimeException("You use pover ZEUS wonder in this age");
            }
            boolean isBuildUseGalicarnas = buildGalicarnas(userActionOnCard);
            boolean noBuiltGalicarnas = !currentUserGameInfo.isBuiltGalicarnas();
            if (isBuildUseGalicarnas && noBuiltGalicarnas) {
                throw new RuntimeException("You no build GalicarnasAbility in this raund");
            }

            boolean isMoreLevelWonderThenMax = isMoreLevelWonderThenMax(currentUserGameInfo);
            if (isMoreLevelWonderThenMax) {
                throw new RuntimeException("You want build wonder Level more then max");
            }
/**
 * Build ZEUS,BUILD,CHAIN
 */
// ACTION BUILD CARD OR BUILD WONDER
            if (GameUserInfoUtils.isBuild(userActionOnCard) || userActionOnCard.equals(UserActionOnCard.BUILD_WONDER)) {

                List<BaseResource> resourcesNeed = currentEventGameCard.getResourcesNeedForBuild();
                List<ResourceChooseDto> resourceChooseDtos = eventDto.getResourceChooseDtoList();
                List<PayDto> payDtoList = eventDto.getPayDtoList();
                int goldNeedForConstuction = currentEventGameCard.getGoldNeededForConstruction();
                int userGoldAfterEvent = currentUserGameInfo.getUserGold() - goldNeedForConstuction;
                boolean isNoHaveEnoughtMoney = userGoldAfterEvent < 0;
                if (isNoHaveEnoughtMoney) {
                    throw new RuntimeException("You no have gold for constraction");
                } else {
                    payGoldForBuild(currentEvent, goldNeedForConstuction);

                    boolean isCardNeedResourceForBuild = resourcesNeed.size() > 0;
                    if (isCardNeedResourceForBuild) {

                        int userResourceSize = resourceChooseDtos.size();
                        int buyResourceSize = payDtoList.size();
                        isUserChooseResourceForBuild(userResourceSize, buyResourceSize);

                        GameUserInfo leftUserInfo = gameBoardView.getLeftSiteUser();
                        GameUserInfo rightUserInfo = gameBoardView.getRightSiteUser();
// BASIC RESOURCE COST IN GAME
                        TradeOperation tradeOperation = new TradeOperation();

                        boolean isTradeDiscountBrownLeft = currentUserGameInfo.isTradeBrownLeft();
                        if (isTradeDiscountBrownLeft) {
                            tradeOperation.setBuyBrouwnLeft(1);
                        }
                        boolean isTradeDiscountBrownRight = currentUserGameInfo.isTradeBrownRight();
                        if (isTradeDiscountBrownRight) {
                            tradeOperation.setBuyBrouwnRight(1);
                        }

                        boolean isTradeSilverDiscountRightAndLeft = currentUserGameInfo.isTradeSilverRightAndLeft();
                        if (isTradeSilverDiscountRightAndLeft) {
                            tradeOperation.setBuySilver(1);
                        }
//*** SET ANOTHER COST IF HAVE SPECIAL CARD
                        int goldNeedPayLeft = 0;
                        int goldNeedPayRight = 0;

                        List<BaseResource> allChooseResource = new ArrayList<>();

                        for (ResourceChooseDto chooseDto : resourceChooseDtos) {
                            userChooseTrueResourcesByCard(chooseDto);
                            allChooseResource.addAll(chooseDto.getResourceChoose());
                        }

                        for (PayDto payDto : payDtoList) {
                            ActionSide actionSide = payDto.getActionSide();
                            GameCardColor cardColor = payDto.getGameCard().getGameCardColor();
                            if (actionSide.equals(ActionSide.LEFT)) {

                                boolean noHaveChooseCardLeft = !leftUserInfo.getUserBuiltCards().contains(payDto.getGameCard());
                                if (noHaveChooseCardLeft) {
                                    throw new RuntimeException("Left player no have card whis this name" + payDto.getGameCard());
                                } else {
                                    // TODO REFACTORING
                                    userChooseTrueResourcesByCardPay(payDto);
                                    if (cardColor.equals(GameCardColor.BROWN)) {
                                        goldNeedPayLeft += tradeOperation.getBuyBrouwnLeft();
                                    } else if (cardColor.equals(GameCardColor.SILVER)) {
                                        goldNeedPayLeft += tradeOperation.getBuySilver();
                                    }
                                    if (currentUserGameInfo.getUserGold() - (goldNeedPayLeft + goldNeedPayRight) < 0) {
                                        throw new RuntimeException("Need more gold more buying resourse");
                                    }
                                    allChooseResource.addAll(payDto.getBuyResourceList());
                                }

                            } else if (actionSide.equals(ActionSide.RIGHT)) {
                                if (!rightUserInfo.getUserBuiltCards().contains(payDto.getGameCard())) {
                                    throw new RuntimeException("right player no have card whis this name" + payDto.getGameCard());
                                } else {
                                    // TODO REFACTORING
                                    userChooseTrueResourcesByCardPay(payDto);
                                    if (cardColor.equals(GameCardColor.BROWN)) {
                                        goldNeedPayRight += tradeOperation.getBuyBrouwnRight();
                                    } else if (cardColor.equals(GameCardColor.SILVER)) {
                                        goldNeedPayRight += tradeOperation.getBuySilver();
                                    }
                                    if (currentUserGameInfo.getUserGold() - (goldNeedPayLeft + goldNeedPayRight) < 0) {
                                        throw new RuntimeException("Need more gold more buying resourse");
                                    }
                                    allChooseResource.addAll(payDto.getBuyResourceList());
                                }
                            }
                        }
                        for (BaseResource b : resourcesNeed) {
                            if (!allChooseResource.remove(b)) {
                                throw new RuntimeException("Not have needed resourse for constuction(building)");
                            }
                        }
                        if (goldNeedPayLeft > 0) {
                            Event eventToSave = gameBoardView.getLeftSiteUser().getEventToSave();
                            eventToSave.setGoldChange(goldNeedPayLeft);
                            save(eventToSave);
                        }
                        if (goldNeedPayRight > 0) {
                            Event eventToSave = gameBoardView.getRightSiteUser().getEventToSave();
                            eventToSave.setGoldChange(goldNeedPayRight);
                            save(eventToSave);

                        }
                    }
                }
            }
            /**
             * Build ZEUS,BUILD,CHAIN
             */
        }

// TODO ASK NEED SAVE CARD_SET_ITEM
        save(currentEvent);
        // Send a message with a POJO - the template reuse the message converter
        TransferEvent transferEvent = new TransferEvent(game.getId(), userInGame.getId(), game.getPhaseGame(),
                game.getPhaseRound(), game.getPhaseChooseDo());
        jmsTemplate.convertAndSend("transferEvent", transferEvent);
    }

    protected void isUserChooseResourceForBuild(int userResourceSize, int buyResourceSize) {
        boolean isUserNoChooseResourceForBuild = userResourceSize == 0 & buyResourceSize == 0;
        if (isUserNoChooseResourceForBuild) {
            throw new RuntimeException("You no can build this card, no choose resource for build");
        }
    }

    protected void payGoldForBuild(Event currentEvent, int goldNeedForConstuction) {
        currentEvent.setGoldChange(goldNeedForConstuction);
    }

    protected void addCanBuildByChain(GameUserInfo currentUserGameInfo) {
        currentUserGameInfo.setCanBuildByChainCurrentCard(true);
    }

    protected void exeptionForDublicate(UserActionOnCard userActionOnCard, Event currentEvent) {
        if (GameUserInfoUtils.isBuild(userActionOnCard) ||
                GameUserInfoUtils.isBuildZeus(userActionOnCard) ||
                isBuildChain(currentEvent.getChainCard()) ||
                buildGalicarnas(userActionOnCard)) {
            throw new RuntimeException("You want buil duplicate");
        }

    }

    protected void addGoldForSale(Event currentEvent) {
        currentEvent.setGoldChange(3);
    }

    protected boolean buildGalicarnas(UserActionOnCard userActionOnCard) {
        return userActionOnCard.equals(UserActionOnCard.RESORECT_CARD);
    }

    /**
     * metod watch correct choose resourse by one card
     *
     * @param shouldBeChosen      Card can have two resource but need choose one
     * @param cardGiveResourse
     * @param chooseResoureByUser
     */
    protected void correctChooseResource(boolean shouldBeChosen, List<BaseResource> cardGiveResourse, List<BaseResource> chooseResoureByUser) {
        if (shouldBeChosen) {
            if (chooseResoureByUser.size() > 1) {
                throw new RuntimeException("You choose two resource where need choose one");
            } else {
                for (BaseResource resourseChoose : chooseResoureByUser) {
                    if (!cardGiveResourse.remove(resourseChoose)) {
                        throw new RuntimeException("You choose resourse what not have card");
                    }
                }
            }
        } else {
            for (BaseResource resourseChoose : chooseResoureByUser) {
                if (!cardGiveResourse.remove(resourseChoose)) {
                    throw new RuntimeException("You choose resourse what not have card");
                }
            }
        }
    }

    /**
     * metod check correct choose resource by user card in one card
     *
     * @param cardResourChoose
     * @return
     */
    protected boolean userChooseTrueResourcesByCard(ResourceChooseDto cardResourChoose) {
        GameResource cardGiveResourse = cardResourChoose.getCard().getGiveResource();
        boolean shouldBeChosen = cardGiveResourse.getShouldBeChosen();
        List<BaseResource> cardBaseResource = new ArrayList<>(cardGiveResourse.getResources());
        correctChooseResource(shouldBeChosen, cardBaseResource, cardResourChoose.getResourceChoose());
        return true;
    }

    /**
     * metod check correct choose resource by pay
     *
     * @param payDto
     * @return
     */
    protected boolean userChooseTrueResourcesByCardPay(PayDto payDto) {
        GameResource cardGiveResourse = payDto.getGameCard().getGiveResource();
        boolean shouldBeChosen = cardGiveResourse.getShouldBeChosen();
        List<BaseResource> cardBaseResource = new ArrayList<>(cardGiveResourse.getResources());
        correctChooseResource(shouldBeChosen, cardBaseResource, payDto.getBuyResourceList());
        return true;
    }

    protected boolean checkCorrectChain(GameCard card, GameCard chainCard) {
        return card.getChain().stream()
                .anyMatch(s -> s.equals(chainCard.name()));
    }

    protected boolean isBuildChain(GameCard chainCard) {
        return chainCard != null;
    }

    @Override
    public BoardDto getCurrentBoard(Long gameId) {
        Game game = gameService.findGameById(gameId);

        // TODO CHANGE AGE OR WONDER HAVE + MOVE
        // TODO CARD ON HAND
        return gameBoardDtoConverter.convertToDto(game);
    }


    public boolean isMoreLevelWonderThenMax(GameUserInfo currentUserGameInfo) {
        int wonderLevel = currentUserGameInfo.getWonderLevel();
        int maxWonderLevel = currentUserGameInfo.getWonder().getWonderLevelCard().size();
        return wonderLevel >= maxWonderLevel;
    }
}





