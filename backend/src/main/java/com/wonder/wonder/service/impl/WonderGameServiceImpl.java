package com.wonder.wonder.service.impl;

import com.wonder.wonder.cards.*;
import com.wonder.wonder.dto.EventDto;
import com.wonder.wonder.dto.PayDto;
import com.wonder.wonder.dto.ResourceChooseDto;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.phase.UserActionOnCard;
import com.wonder.wonder.phase.GamePhase;
import com.wonder.wonder.service.EventService;
import com.wonder.wonder.service.GameService;
import com.wonder.wonder.service.UserInGameService;
import com.wonder.wonder.service.WonderGameService;
import com.wonder.wonder.service.util.GameBoardView;
import com.wonder.wonder.service.util.GameUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    protected boolean build(UserActionOnCard userActionOnCard) {
        return userActionOnCard.equals(UserActionOnCard.BUILD);

    }

    protected boolean buildZeus(UserActionOnCard eventUserChoose) {
        return eventUserChoose.equals(UserActionOnCard.BUILD_ZEUS);
    }

    protected boolean buildWonder(UserActionOnCard userActionOnCard) {
        return userActionOnCard.equals(UserActionOnCard.BUILD_WONDER);
    }

    protected int getFoldChange(GameBoardView gameBoardView, Event currentEvent) {
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

        GameBoardView gameBoardView = new GameBoardView(game, eventDto.getUserInGameId());
        GameUserInfo gameUserInfo = gameBoardView.getCurrentUserGameInfo();

        Event currentEvent = gameUserInfo.getEventToSave();
        currentEvent.setUserInGame(currentEvent.getUserInGame());
        currentEvent.setGamePhase(game.getPhaseGame());
        currentEvent.setPhaseRound(game.getPhaseRound());
        currentEvent.setPhaseChooseDo(game.getPhaseChooseDo());
        currentEvent.setCard(eventDto.getPlayOnCardForEvent());
        currentEvent.setChainCard(eventDto.getChainCard());
        currentEvent.setUserActionOnCard(eventDto.getUserActionOnCard());

        /**
         * Action sell card
         */
        if (sellCard(currentEvent.getUserActionOnCard())) {
            currentEvent.setGoldChange(3);
            save(currentEvent);
            return true;
        }

        boolean canBuildByChain = false;
        for (Event eventPastSteps : gameBoardView.getAllEvents()) {

            GameCard eventPastStepsCard = eventPastSteps.getCard();
            UserActionOnCard pastPlayCardChoose = eventPastSteps.getUserActionOnCard();
            GamePhase pastEventPhase = eventPastSteps.getGamePhase();
            GameCard pastChainBuild = eventPastSteps.getChainCard();


            /**
             * exeptions
             */
            if (wantBuildDublicate(eventPastStepsCard, currentEvent.getCard(), pastPlayCardChoose)) {
                throw new RuntimeException("You want buil dublicate");
            }
            if (wantBuildByZeusWhenUseInThisAge(currentEvent.getUserActionOnCard(), currentEvent.getGamePhase(), pastPlayCardChoose, pastEventPhase)) {
                throw new RuntimeException("You use pover ZEVS wonder in this age");
            }
            if (gameUserInfo.getWonderLevel() > gameUserInfo.getWonder().getWonderLevelCard().size()) {
                throw new RuntimeException("You want build wonderLEvel more then max");
            }

            /**
             * exeptions
             */
            if (buildChain(currentEvent.getChainCard())) {
                // TODO CHECK HAVE THIS BUILD CARD FOR CHAIN
            }
        }
/**
 * Build ZEUS,BUILD,CHAIN
 */
        if (buildZeus(currentEvent.getUserActionOnCard())) {
            int goldChangeOnBuild = getFoldChange(gameBoardView, currentEvent);

            currentEvent.setGoldChange(goldChangeOnBuild);
            // TODO CHECK HAVE THIS BUILD CARD
            save(currentEvent);
            return true;
        }


        List<BaseResource> resourcesNeed = currentEvent.getCard().getResourcesNeedForBuild();
        List<ResourceChooseDto> resourceChooseDto = eventDto.getResourceChooseDtoList();
        List<PayDto> payDtoList = eventDto.getPayDtoList();

        if (build(currentEvent.getUserActionOnCard())) {
            int goldChangeOnBuild = getFoldChange(gameBoardView, currentEvent);

            if (buildChain(currentEvent.getChainCard())) {
                save(currentEvent);
                return true;
            }

            if (currentEvent.getCard().getGoldNeededForConstruction() == 0
                    & resourcesNeed.get(0).equals(BaseResource.NONE)) {
                currentEvent.setGoldChange(goldChangeOnBuild);
                save(currentEvent);
                return true;
            }
            if ((currentEvent.getCard().getGoldNeededForConstruction() == 1)
                    & ((currentEvent.getGoldChange() - 1) >= 0) &
                    resourcesNeed.get(0).equals(BaseResource.NONE)) {
                currentEvent.setGoldChange(goldChangeOnBuild - 1);
                save(currentEvent);
                return true;

            }

            if ((currentEvent.getCard().getGoldNeededForConstruction() == 0)
                    & !resourcesNeed.get(0).equals(BaseResource.NONE)) {




                currentEvent.setGoldChange(goldChangeOnBuild);
                save(currentEvent);
                return true;

            }

            // TODO BUILD BY RESOURCE LIKE METOD

//            if (resourceChooseDto.size() == 0 & payDtoList.size() == 0){
//                throw new RuntimeException("You no can build this card, no choose resource for build");
//            }

        }

        if (buildWonder(currentEvent.getUserActionOnCard())) {
            // TODO BUILD BY RESOURCE LIKE METOD
            return true;
        }

        /**
         * Build ZEUS,BUILD,CHAIN
         */
        return true;
    }

    protected boolean cardGiveResources(GameResource pastCardgiveResource) {
        return !pastCardgiveResource.equals(GameResource.NO_RESOURCE);
    }

    protected boolean buildChain(GameCard pastChainBuild) {
        return pastChainBuild != null;
    }

    protected boolean wantBuildByZeusWhenUseInThisAge(UserActionOnCard eventUserChoose, GamePhase phaseGameAndAge,
                                                      UserActionOnCard pastPlayCardChoose, GamePhase pastEventPhase) {
        return buildZeus(eventUserChoose) & eventUserChoose.equals(pastPlayCardChoose) &
                phaseGameAndAge.equals(pastEventPhase);
    }

    protected boolean wantBuildDublicate(GameCard eventPastStepsCard, GameCard playCard,
                                         UserActionOnCard pastPlayCardChoose) {
        return eventPastStepsCard.equals(playCard)
                & build(pastPlayCardChoose) |
                buildZeus(pastPlayCardChoose);
    }


    @Override
    public Game getCurrentBoard(Long gameId) {
        return null;
    }

}


// if all players played card
// then
//        doFinishStroke();





