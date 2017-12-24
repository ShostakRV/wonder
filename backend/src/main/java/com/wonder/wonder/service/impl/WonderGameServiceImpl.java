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


    private void save(UserInGame userInGame, Game game,
                      GamePhase gamePhase, Integer round, Integer gamePhaseRound,
                      GameCard playCard, UserActionOnCard userActionOnCard, GameCard chainCard,
                      Integer goldChange) {
        Event event = new Event();
        event.setGame(game);
        event.setUserInGame(userInGame);
        event.setGamePhase(gamePhase);
        event.setPhaseRound(round);
        event.setPhaseChooseDo(gamePhaseRound);
        event.setCard(playCard);
        event.setUserActionOnCard(userActionOnCard);
        event.setChainCard(chainCard);
        event.setGoldChange(goldChange);
        eventService.save(event);
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

    @Override
    public boolean playCard(EventDto eventDto) {

        /**
         * basic parametr for users
         */
        UserInGame userInGame = userInGameService.getUserInGameById(eventDto.getUserInGameId());
        WonderCard userWonder = userInGame.getWonder();
        Game game = userInGame.getGame();
        GamePhase phaseGameAndAge = game.getPhaseGame();
        Integer round = game.getPhaseRound();
        Integer roundPhaseScooseDo = game.getPhaseChooseDo();
        GameCard playCard = eventDto.getPlayCard();
        GameCard chainCard = eventDto.getChainCard();
        UserActionOnCard eventUserChoose = eventDto.getEventUserChoose();
        Integer goldHaveUser = 3;
        Integer wonderLevel = 0;

        /**
         * Action sell card
         */
        if (sellCard(eventUserChoose)) {
            save(userInGame, game
                    , phaseGameAndAge, round, roundPhaseScooseDo
                    , playCard, eventUserChoose, chainCard
                    , 3);
            return true;
        }

        List<ResourceChooseDto> resourceChooseDto = eventDto.getResourceChooseDtoList();
        List<PayDto> payDtoList = eventDto.getPayDtoList();

// TODO DAO CHANGE getAllEventByGameIdAndUserInGameId
        List<Event> allEventInGame = eventService.getAllEventByGameId(game.getId());
        List<Event> allEventUser = allEventInGame.stream().
                filter(event -> event.getUserInGame().getId() == userInGame.getId()).
                collect(Collectors.toList());

        /**
         * Count resourse what have 
         * Count gold what have
         * Count what ability have
         *
         */

        List<GameCard> cardWasBuild = new ArrayList<>();
        List<GameResource> resourceWhatHaveUser = new ArrayList<>();
        List<PassiveAbility> passiveAbilities = new ArrayList<>();
        int warPoint = 0;
        for (Event eventPastSteps : allEventUser) {
            goldHaveUser += eventPastSteps.getGoldChange();
            GameCard eventPastStepsCard = eventPastSteps.getCard();
            UserActionOnCard pastPlayCardChoose = eventPastSteps.getUserActionOnCard();
            GamePhase pastEventPhase = eventPastSteps.getGamePhase();
            GameCard pastChainBuild = eventPastSteps.getChainCard();
            GameResource pastCardgiveResource = eventPastStepsCard.getGiveResource();
            /**
             * Count
             */
            if (resourceWhatHaveUser.size() == 0) {
                resourceWhatHaveUser.add(userWonder.getWonderLevelCard().get(0).getGiveResource());
            }
            if (buildWonder(pastPlayCardChoose)) {
                ++wonderLevel;
                GameCard wonderLevelBuilNow = userWonder.getWonderLevelCard().get(wonderLevel);
                warPoint += wonderLevelBuilNow.getArmyPower().getPoints();
                if (cardGiveResources(wonderLevelBuilNow.getGiveResource())) {
                    resourceWhatHaveUser.add(wonderLevelBuilNow.getGiveResource());
                }
                // count spell
                // count money
//                goldHaveUser +=

            }
            if (build(pastPlayCardChoose)) {
                goldHaveUser -= eventPastStepsCard.getGoldNeededForConstruction();
                cardWasBuild.add(eventPastStepsCard);
                if (cardGiveResources(pastCardgiveResource)) {
                    resourceWhatHaveUser.add(pastCardgiveResource);
                }
                // count spell
                // count money
            }
            if (buildZeus(pastPlayCardChoose)) {
                cardWasBuild.add(eventPastStepsCard);
                if (cardGiveResources(pastCardgiveResource)) {
                    resourceWhatHaveUser.add(pastCardgiveResource);
                }
                // count spell
                // count money
            }

            if (sellCard(pastPlayCardChoose)) {
                goldHaveUser += 3; // !!!!!!
            }

            if (buildChain(pastChainBuild)) {
                cardWasBuild.add(eventPastStepsCard);
                if (cardGiveResources(pastCardgiveResource)) {
                    resourceWhatHaveUser.add(pastCardgiveResource);
                }

                // count spell
                // count money
            }
            /**
             * Count
             */
            /**
             * exeptions
             */
            if (wantBuildDublicate(eventPastStepsCard, playCard, pastPlayCardChoose)) {
                throw new RuntimeException("You want buil dublicate");
            }
            if (wantBuildByZeusWhenUseInThisAge(eventUserChoose, phaseGameAndAge, pastPlayCardChoose, pastEventPhase)) {
                throw new RuntimeException("You use pover ZEVS wonder in this age");
            }
            if (wonderLevel > userWonder.getWonderLevelCard().size()) {
                throw new RuntimeException("You want build wonderLEvel more then max");
            }
            if (buildChain(chainCard) &
                    (buildChain(pastChainBuild) &
                            Objects.equals(pastEventPhase, phaseGameAndAge))) {
                throw new RuntimeException("You no can build by doudle chain in one age");
            }

            /**
             * exeptions
             */
        }
/**
 * Build ZEUS,BUILD,CHAIN
 */
        List<BaseResource> resourcesNeed = playCard.getResourcesNeedForBuild();
        int goldChangeOnBuild = 0; // TODO CNAHGE GOLD
        if (build(eventUserChoose)) {
            if (playCard.getGoldNeededForConstruction() == 0 &
                    playCard.getResourcesNeedForBuild().get(0).equals(BaseResource.NONE)) {


                save(userInGame, game
                        , phaseGameAndAge, round, roundPhaseScooseDo
                        , playCard, eventUserChoose, chainCard
                        , goldChangeOnBuild);
                return true;
            }
            if ((playCard.getGoldNeededForConstruction() == 1) &
                    ((goldHaveUser - 1) >= 0) &
                    playCard.getResourcesNeedForBuild().get(0).equals(BaseResource.NONE)) {
                save(userInGame, game
                        , phaseGameAndAge, round, roundPhaseScooseDo
                        , playCard, eventUserChoose, chainCard
                        , goldChangeOnBuild - 1);
                return true;
            }
            // TODO BUILD BY RESOURCE LIKE METOD

//            if (resourceChooseDto.size() == 0 & payDtoList.size() == 0){
//                throw new RuntimeException("You no can build this card, no choose resource for build");
//            }


            if (buildChain(chainCard)) {
                // TODO CHECK HAVE THIS BUILD CARD
                save(userInGame, game
                        , phaseGameAndAge, round, roundPhaseScooseDo
                        , playCard, eventUserChoose, chainCard
                        , goldChangeOnBuild);
                return true;
            }
        }
        if (buildZeus(eventUserChoose)) {
            save(userInGame, game
                    , phaseGameAndAge, round, roundPhaseScooseDo
                    , playCard, eventUserChoose, chainCard
                    , goldChangeOnBuild);
            return true;
        }
        if (buildWonder(eventUserChoose)) {
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





