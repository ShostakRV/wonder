package com.wonder.wonder.service.impl;

import com.wonder.wonder.cards.BaseResource;
import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.MainCard;
import com.wonder.wonder.cards.WonderCard;
import com.wonder.wonder.dto.BoardDto;
import com.wonder.wonder.dto.EventDto;
import com.wonder.wonder.dto.PayDto;
import com.wonder.wonder.dto.ResourceChooseDto;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.phase.EventPhaseUserChoose;
import com.wonder.wonder.phase.GamePhase;
import com.wonder.wonder.service.EventService;
import com.wonder.wonder.service.GameService;
import com.wonder.wonder.service.UserInGameService;
import com.wonder.wonder.service.WonderGameService;
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
    private GameService gameService;

    private EventService eventService;

    private UserInGameService userInGameService;

    private BoardDto boardDto;


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
                      GameCard playCard, EventPhaseUserChoose eventPhaseUserChoose, MainCard chainCard,
                      Integer goldChange) {
        Event event = new Event();
        event.setGame(game);
        event.setUserInGame(userInGame);
        event.setGamePhase(gamePhase);
        event.setPhaseRound(round);
        event.setPhaseChooseDo(gamePhaseRound);
        event.setCard((MainCard) playCard);
        event.setEventPhaseUserChoose(eventPhaseUserChoose);
        event.setChainCard(chainCard);
        event.setGoldChange(goldChange);
        eventService.save(event);
    }

    @Override
    public void playCard(EventDto eventDto) {

        UserInGame userInGame = userInGameService.getUserInGameById(eventDto.getUserInGameId());
        WonderCard userWonder = userInGame.getWonder();
        Game game = userInGame.getGame();
        GamePhase phaseGame = game.getPhaseGame();
        Integer round = game.getPhaseRound();
        Integer roundPhase = game.getPhaseChooseDo();
        GameCard playCard = eventDto.getPlayCard();
        MainCard chainCard = eventDto.getChainCard();
        EventPhaseUserChoose eventUserChoose = eventDto.getEventUserChoose();
        Integer goldHaveUser = 3;
        Integer wonderLevel = 0;
        if (eventDto.getEventUserChoose().equals(EventPhaseUserChoose.SELL_CARD)) {
            save(userInGame, game
                    , phaseGame, round, roundPhase
                    , playCard, eventUserChoose, chainCard
                    , 3);

        }

        List<ResourceChooseDto> resourceChooseDto = eventDto.getResourceChooseDtoList();
        List<PayDto> payDtoList = eventDto.getPayDtoList();

        List<Event> allEventInGame = eventService.getAllEventByGameId(game.getId());
        List<Event> allEventUser = allEventInGame.stream().
                filter(event -> event.getUserInGame().getId() == userInGame.getId()).
                collect(Collectors.toList());

        if (eventDto.getEventUserChoose().equals(EventPhaseUserChoose.BUILD_WONDER) |
                eventDto.getEventUserChoose().equals(EventPhaseUserChoose.BUILD) |
                eventDto.getEventUserChoose().equals(EventPhaseUserChoose.BUILD_ZEUS)) {
            List<GameCard> cardWasBuild = new ArrayList<>();

            for (Event event : allEventUser) {
                goldHaveUser += event.getGoldChange();

                if (event.getCard().equals(playCard) & event.getEventPhaseUserChoose().equals(EventPhaseUserChoose.BUILD)) {
                    throw new RuntimeException("You want buil dublicate");
                }

                if (event.getEventPhaseUserChoose().equals(EventPhaseUserChoose.BUILD_WONDER)) {
                    ++wonderLevel;
                    if (wonderLevel > userWonder.getWonderLevelCard().size()) {
                        throw new RuntimeException("You want build wonderLEvel more then max");
                    }
                }
                if (event.getEventPhaseUserChoose().equals(EventPhaseUserChoose.BUILD_ZEUS) & event.getGamePhase().equals(phaseGame)) {
                    throw new RuntimeException("You use pover wonder in this age");
                }
                if (event.getEventPhaseUserChoose().equals(EventPhaseUserChoose.BUILD) |
                        event.getEventPhaseUserChoose().equals(EventPhaseUserChoose.BUILD_WONDER) |
                        event.getEventPhaseUserChoose().equals(EventPhaseUserChoose.BUILD_ZEUS)) {
                    cardWasBuild.add(event.getCard());
                }

                if (chainCard != null) {
                    if (event.getChainCard() != null & Objects.equals(event.getGamePhase(), phaseGame)) {
                        throw new RuntimeException("You no can build by doudle chain in one age");
                    }
                    if (chainCard.equals(event.getCard()) & playCard.getChain().equals(event.getCard())) {
//                        save(userInGame, game
//                                , age, round, roundPhase
//                                , playCard, eventUserChoose, chainCard
//                                , 3); // what do this gold
                    }
                }

            }

            if (playCard.getResourcesNeedForBuild().size() == 0) {
                if (playCard.getGoldNeededForConstruction() == 0) {
                    save(userInGame, game
                            , phaseGame, round, roundPhase
                            , playCard, eventUserChoose, chainCard
                            , 0);
                }
                if ((playCard.getGoldNeededForConstruction() == 1) &
                        ((goldHaveUser - 1) >= 0)) {
                    save(userInGame, game
                            , phaseGame, round, roundPhase
                            , playCard, eventUserChoose, chainCard
                            , -1);
                }
            }
            if (resourceChooseDto.size() == 0 & payDtoList.size() == 0) {
                throw new RuntimeException("You no can build this card, no choose resource for build");
            }
            List<BaseResource> resourcesNeed = playCard.getResourcesNeedForBuild();


        }
    }

}


// if all players played card
// then
//        doFinishStroke();





