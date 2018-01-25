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
import com.wonder.wonder.service.util.GameUserInfoUtils;

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

    // TODO GO TO PHASE TWO
    protected int getGoldChange(GameBoardView gameBoardView, Event currentEvent) {
        currentEvent.getCard().getOnBuildEvent().doAction(gameBoardView);
        return currentEvent.getGoldChange();
    }

    protected Event createNewEventAndSetNeedFields(Event currentEvent, int goldChange) {
        Event newEvent = new Event();
        newEvent.setGame(currentEvent.getGame());
        newEvent.setUserInGame(currentEvent.getUserInGame());
        newEvent.setGamePhase(currentEvent.getGamePhase());
        newEvent.setPhaseRound(currentEvent.getPhaseRound());
        newEvent.setPhaseChooseDo(currentEvent.getPhaseChooseDo());
        newEvent.setGoldChange(goldChange);
        return newEvent;
    }

    @Override
    public void playCard(EventDto eventDto) {
        /**
         * basic parametr for users
         */
        UserInGame userInGame = userInGameService.getUserInGameByIdAndGameId(eventDto.getUserInGameId()
                , eventDto.getGameId());
        Game game = userInGame.getGame();

        List<GameUserInfo> gameUserInfos = new ArrayList<>(GameUserInfoUtils
                .createGameUserInfo(game.getEvents()).values());

        GameBoardView gameBoardView = new GameBoardView(game, eventDto.getUserInGameId(), gameUserInfos);
        GameUserInfo gameUserInfo = gameBoardView.getCurrentUserGameInfo();

        Event currentEvent = gameUserInfo.getEventToSave();
        currentEvent.setCard(eventDto.getPlayOnCardForEvent());
        currentEvent.setChainCard(eventDto.getChainCard());
        currentEvent.setUserActionOnCard(eventDto.getUserActionOnCard());

        //TODO FOR WONDER WHAT PUT
//        currentEvent.setToPutOnForBuild(eventDto.ge);
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
                        && GameUserInfoUtils.build(currentEvent.getUserActionOnCard())
                        || builtCard.equals(currentEvent.getCard())
                        && GameUserInfoUtils.buildZeus(currentEvent.getUserActionOnCard())
                        || builtCard.equals(currentEvent.getCard())
                        && buildChain(currentEvent.getChainCard())
                        || builtCard.equals(currentEvent.getCard())
                        && buildGalicarnas(currentEvent.getUserActionOnCard())) {
                    throw new RuntimeException("You want buil dublicate");
                }

                if (buildChain(currentEvent.getChainCard())
                        && checkCorrectChain(currentEvent.getCard(), currentEvent.getChainCard())) {
                    if (builtCard.equals(currentEvent.getChainCard())) {
                        gameUserInfo.setCanBuildByChainCurrentCard(true);
                    }
                }
            }
            if (buildChain(currentEvent.getChainCard())
                    && !gameUserInfo.isCanBuildByChainCurrentCard()) {
                throw new RuntimeException("You no can build by chain");
            }

            if (GameUserInfoUtils.buildZeus(currentEvent.getUserActionOnCard())
                    && !gameUserInfo.isZeusPassiveWonderActive()) {
                throw new RuntimeException("You use pover ZEVS wonder in this age");
            }

            if (buildGalicarnas(currentEvent.getUserActionOnCard())
                    && !gameUserInfo.isBuildGalicarnas()) {
                throw new RuntimeException("You no build GalicarnasAbility in this raund");
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

            if (GameUserInfoUtils.build(currentEvent.getUserActionOnCard())
                    || GameUserInfoUtils.buildWonder(currentEvent.getUserActionOnCard())) {

                List<BaseResource> resourcesNeed = currentEvent.getCard().getResourcesNeedForBuild();
                List<ResourceChooseDto> resourceChooseDtos = eventDto.getResourceChooseDtoList();
                List<PayDto> payDtoList = eventDto.getPayDtoList();


                if (gameUserInfo.getUserGold() - currentEvent.getCard().getGoldNeededForConstruction() < 0) {
                    throw new RuntimeException("You no have gold for constraction");
                } else {
                    currentEvent.setGoldChange(currentEvent.getCard().getGoldNeededForConstruction());
                    if (resourcesNeed.size() > 0) {
                        if (resourceChooseDtos.size() == 0 & payDtoList.size() == 0) {
                            throw new RuntimeException("You no can build this card, no choose resource for build");
                        }

                        GameUserInfo left = gameBoardView.getLeftSiteUser();
                        GameUserInfo right = gameBoardView.getRightSiteUser();

                        int buyBrouwnLeft = 2;
                        int buyBrouwnRight = 2;
                        int buySilver = 2;

                        if (gameUserInfo.isTradeBrownLeft()) {
                            buyBrouwnLeft = 1;
                        }
                        if (gameUserInfo.isTradeBrownRight()) {
                            buyBrouwnRight = 1;
                        }
                        if (gameUserInfo.isTradeSilverRightAndLeft()) {
                            buySilver = 1;
                        }
                        int goldNeedPayLeft = 0;
                        int goldNeedPayRight = 0;
                        List<BaseResource> allChooseResource = new ArrayList<>();
                        for (ResourceChooseDto chooseDto : resourceChooseDtos) {
                            userChooseTrueResourcesByCard(chooseDto);
                            allChooseResource.addAll(chooseDto.getResourceChoose());
                        }

                        for (PayDto payDto : payDtoList) {
                            if (payDto.getActionSide().equals(ActionSide.LEFT)) {

                                if (!left.getUserBuiltCards().contains(payDto.getGameCard())) {
                                    throw new RuntimeException("Left player no have card whis this name" + payDto.getGameCard());
                                } else {
                                    userChooseTrueResourcesByCardPay(payDto);
                                    if (payDto.getGameCard().getGameCardColor().equals(GameCardColor.BROWN)) {
                                        goldNeedPayLeft += buyBrouwnLeft;
                                    } else if (payDto.getGameCard().getGameCardColor().equals(GameCardColor.SILVER)) {
                                        goldNeedPayLeft += buySilver;
                                    }
                                    if (gameUserInfo.getUserGold() - (goldNeedPayLeft + goldNeedPayRight) < 0) {
                                        throw new RuntimeException("Need more gold more buying resourse");
                                    }
                                    allChooseResource.addAll(payDto.getBuyResourceList());
                                }

                            } else if (payDto.getActionSide().equals(ActionSide.RIGHT)) {
                                if (!right.getUserBuiltCards().contains(payDto.getGameCard())) {
                                    throw new RuntimeException("right player no have card whis this name" + payDto.getGameCard());
                                } else {
                                    userChooseTrueResourcesByCardPay(payDto);
                                    if (payDto.getGameCard().getGameCardColor().equals(GameCardColor.BROWN)) {
                                        goldNeedPayRight += buyBrouwnRight;
                                    } else if (payDto.getGameCard().getGameCardColor().equals(GameCardColor.SILVER)) {
                                        goldNeedPayRight += buySilver;
                                    }
                                    if (gameUserInfo.getUserGold() - (goldNeedPayLeft + goldNeedPayRight) < 0) {
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
                            save(createNewEventAndSetNeedFields(currentEvent, goldNeedPayLeft));
                        }
                        if (goldNeedPayRight > 0) {
                            save(createNewEventAndSetNeedFields(currentEvent, goldNeedPayRight));
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




        jmsTemplate.convertAndSend("eventToSave", "Hello");
    }

    private boolean buildGalicarnas(UserActionOnCard userActionOnCard) {
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





