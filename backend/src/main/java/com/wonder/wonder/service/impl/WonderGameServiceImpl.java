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
import com.wonder.wonder.service.util.GameBoardView;
import com.wonder.wonder.service.util.GameUserInfo;
import com.wonder.wonder.service.util.GameUserInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

//    private List<Event> eventList;

    //    void exchangeCardSetBetweenPlayers(Game game);
//    void passCardToAnotherUserInGame(Game game);

    //    void war(Game game);


    // can be build card(resource) vs resource another player
    // no have dublicate
    // sale card
    // cpetioal ability end round
    // befor war spetial ability wonder
    // end age war
    // end count point


    private void save(Event currentEvent) {
        eventService.save(currentEvent);
    }

    protected boolean sellCard(UserActionOnCard userActionOnCard) {
        return userActionOnCard.equals(UserActionOnCard.SELL_CARD);
    }

    protected int getGoldChange(GameBoardView gameBoardView, Event currentEvent) {
        currentEvent.getCard().getOnBuildEvent().doAction(gameBoardView);
        return currentEvent.getGoldChange();
    }

    @Override
    public boolean playCard(EventDto eventDto) {
        /**
         * basic parametr for users
         */
        UserInGame userInGame = userInGameService.getUserInGameByIdAndGameId(eventDto.getUserInGameId()
                , eventDto.getGameId());
        Game game = userInGame.getGame();

        List<GameUserInfo> gameUserInfos = new ArrayList<>(GameUserInfoFactory
                .createGameUserInfo(game.getEvents()).values());

        GameBoardView gameBoardView = new GameBoardView(game, eventDto.getUserInGameId(), gameUserInfos);
        GameUserInfo gameUserInfo = gameBoardView.getCurrentUserGameInfo();

        Event currentEvent = gameUserInfo.getEventToSave();
        currentEvent.setCard(eventDto.getPlayOnCardForEvent());
        currentEvent.setChainCard(eventDto.getChainCard());
        currentEvent.setUserActionOnCard(eventDto.getUserActionOnCard());

        /**
         * Action sell card
         */
        if (sellCard(currentEvent.getUserActionOnCard())) {
            currentEvent.setGoldChange(3);

        } else {
            /**
             * exeptions
             */
            for (GameCard builtCard : gameBoardView.getCurrentUserBuildCard()) {

                if (builtCard.equals(currentEvent.getCard())
                        && GameUserInfoFactory.build(currentEvent.getUserActionOnCard())
                        || builtCard.equals(currentEvent.getCard())
                        && GameUserInfoFactory.buildZeus(currentEvent.getUserActionOnCard())
                        || builtCard.equals(currentEvent.getCard())
                        && buildChain(currentEvent.getChainCard())) {
                    throw new RuntimeException("You want buil dublicate");
                }

                if (buildChain(currentEvent.getChainCard())
                        && checkCorrectChain(currentEvent.getCard(), currentEvent.getChainCard())) {
                    if (builtCard.equals(currentEvent.getChainCard())) {
                        gameUserInfo.setCanBuildByChainCurrentCard(true);
                    }
                }
            }

            if (GameUserInfoFactory.buildZeus(currentEvent.getUserActionOnCard())
                    && !gameUserInfo.isZeusPassiveWonderActive()) {
                throw new RuntimeException("You use pover ZEVS wonder in this age");
            }

            if (gameUserInfo.getWonderLevel() > gameUserInfo.getWonder().getWonderLevelCard().size()) {
                throw new RuntimeException("You want build wonderLEvel more then max");
            }
            /**
             * exeptions
             */
/**
 * Build ZEUS,BUILD,CHAIN
 */
            int goldChangeOnBuild = getGoldChange(gameBoardView, currentEvent);
            if (GameUserInfoFactory.buildZeus(currentEvent.getUserActionOnCard())) {
                currentEvent.setGoldChange(goldChangeOnBuild);
            } else {
                List<BaseResource> resourcesNeed = currentEvent.getCard().getResourcesNeedForBuild();
                List<ResourceChooseDto> resourceChooseDtos = eventDto.getResourceChooseDtoList();
                List<PayDto> payDtoList = eventDto.getPayDtoList();
                if (GameUserInfoFactory.build(currentEvent.getUserActionOnCard())) {
                    if (buildChain(currentEvent.getChainCard())
                            && gameUserInfo.isCanBuildByChainCurrentCard()) {
                        currentEvent.setGoldChange(goldChangeOnBuild);

                    } else if (currentEvent.getCard().getGoldNeededForConstruction() == 0
                            && resourcesNeed.get(0).equals(BaseResource.NONE)) {
                        currentEvent.setGoldChange(goldChangeOnBuild);

                    } else if ((currentEvent.getCard().getGoldNeededForConstruction() == 1)
                            && ((currentEvent.getGoldChange() - 1) >= 0) &
                            resourcesNeed.get(0).equals(BaseResource.NONE)) {
                        currentEvent.setGoldChange(goldChangeOnBuild - 1);

                    }

                } else if (GameUserInfoFactory.build(currentEvent.getUserActionOnCard())
                        || GameUserInfoFactory.buildWonder(currentEvent.getUserActionOnCard())) {

                    if ((currentEvent.getCard().getGoldNeededForConstruction() == 0)
                            && !resourcesNeed.get(0).equals(BaseResource.NONE)
                            && userChooseTrueResourcesByCard(resourceChooseDtos)) {

                        if (resourceChooseDtos.size() == 0 & payDtoList.size() == 0) {
                            throw new RuntimeException("You no can build this card, no choose resource for build");
                        }

                        if (payDtoList.size() == 0
                                && canBuildUseResource(resourceChooseDtos, resourcesNeed, payDtoList)) {
                            currentEvent.setGoldChange(goldChangeOnBuild);

                        } else if (userChooseTrueResourcesByCardPay(payDtoList)
                                && (userChooseTrueCardForBuy(payDtoList, gameBoardView))
                                && canBuildUseResource(resourceChooseDtos, resourcesNeed, payDtoList)) {
                            currentEvent.setGoldChange(goldChangeOnBuild);

                        }
                    }
                }
                /**
                 * Build ZEUS,BUILD,CHAIN
                 */
            }
        }
        save(currentEvent);
        return true;
    }

    protected boolean userChooseTrueCardForBuy(List<PayDto> payDtoList, GameBoardView gameBoardView) {
        GameUserInfo left = gameBoardView.getLeftSiteUser();
        GameUserInfo right = gameBoardView.getRightSiteUser();
        for (PayDto payDto : payDtoList) {
            if (payDto.getActionSide().equals(ActionSide.LEFT)) {
                if (!left.getUserBuiltCards().contains(payDto.getGameCard())) {
                    throw new RuntimeException("Left player no have card whis this name" + payDto.getGameCard());
                }
            } else if (payDto.getActionSide().equals(ActionSide.RIGHT)) {
                if (!right.getUserBuiltCards().contains(payDto.getGameCard())) {
                    throw new RuntimeException("Left player no have card whis this name" + payDto.getGameCard());
                }
            }
        }
        return true;
    }

    protected boolean userChooseTrueResourcesByCardPay(List<PayDto> payDtoList) {
        for (PayDto payDto : payDtoList) {
            GameResource cardGiveResourse = payDto.getGameCard().getGiveResource();
            boolean shouldBeChosen = cardGiveResourse.getShouldBeChosen();
            List<BaseResource> cardBaseResource = new ArrayList<>(cardGiveResourse.getResources());
            correctChooseResource(shouldBeChosen, cardBaseResource, payDto.getBuyResourceList());
        }
        return true;
    }

    protected boolean canBuildUseResource(List<ResourceChooseDto> resourceChooseDto, List<BaseResource> resourcesNeed, List<PayDto> payDtoList) {
        List<BaseResource> allChooseResource = new ArrayList<>();
        for (ResourceChooseDto r : resourceChooseDto) {
            allChooseResource.addAll(r.getResourceChoose());
        }
        for (PayDto p : payDtoList) {
            allChooseResource.addAll(p.getBuyResourceList());
        }
        for (BaseResource b : resourcesNeed) {
            if (!allChooseResource.remove(b)) {
                throw new RuntimeException("Not have needed resourse for constuction(building)");
            }
        }
        return true;
    }

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

    protected boolean userChooseTrueResourcesByCard(List<ResourceChooseDto> chooseDtoList) {
        for (ResourceChooseDto cardResourChoose : chooseDtoList) {
            GameResource cardGiveResourse = cardResourChoose.getCard().getGiveResource();
            boolean shouldBeChosen = cardGiveResourse.getShouldBeChosen();
            List<BaseResource> cardBaseResource = new ArrayList<>(cardGiveResourse.getResources());
            correctChooseResource(shouldBeChosen, cardBaseResource, cardResourChoose.getResourceChoose());
        }
        return true;
    }

    protected boolean checkCorrectChain(GameCard card, GameCard chainCard) {
        return card.getChain().stream()
                .anyMatch(s -> s.equals(chainCard.name()));
    }

    protected boolean buildChain(GameCard chainCard) {
        return chainCard != null;
    }

    @Override
    public BoardDto getCurrentBoard(Long gameId) {
        Game game = gameService.findGameById(gameId);

        // TODO CHANGE AGE OR WONDER HAVE + MOVE
        // TODO CARD ON HAND
        return gameBoardDtoConverter.convertToDto(game);
    }
}





