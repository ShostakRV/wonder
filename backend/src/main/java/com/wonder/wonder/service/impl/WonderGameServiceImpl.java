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
import com.wonder.wonder.phase.GamePhase;
import com.wonder.wonder.phase.UserActionOnCard;
import com.wonder.wonder.service.*;
import com.wonder.wonder.service.util.GameBoardView;
import com.wonder.wonder.service.util.GameUserInfo;
import com.wonder.wonder.service.util.GameUserInfoUtils;

import com.wonder.wonder.service.util.TransferEvent;
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

    private void save(Event currentEvent) {
        eventService.save(currentEvent);
    }

    protected boolean sellCard(UserActionOnCard userActionOnCard) {
        return userActionOnCard.equals(UserActionOnCard.SELL_CARD);
    }


    @Override
    public void playCard(EventDto eventDto) {
        /**
         * basic parametr for users
         */
// GET CURRENT USERINGAME FOR CURRENT GAME
        UserInGame userInGame = userInGameService.getUserInGameByIdAndGameId(eventDto.getUserInGameId()
                , eventDto.getGameId());
        Game game = userInGame.getGame();

// CALCULATE ALL NEED INFORMATION
        List<GameUserInfo> gameUserInfos = new ArrayList<>(GameUserInfoUtils
                .createGameUserInfo(game.getEvents()).values());
// CREATE BOARD LIKE ORIGIN IN GAME FOR KNOW WHO LEFT WHO RIGHT
        GameBoardView gameBoardView = new GameBoardView(game, eventDto.getUserInGameId(), gameUserInfos);
// CURRENT USER INFORMATION ABOUT GAME
        GameUserInfo currentUserGameInfo = gameBoardView.getCurrentUserGameInfo();

        Event currentEvent = currentUserGameInfo.getEventToSave();
        currentEvent.setCard(eventDto.getPlayOnCardForEvent());
        currentEvent.setChainCard(eventDto.getChainCard());
        currentEvent.setUserActionOnCard(eventDto.getUserActionOnCard());
        currentEvent.setToPutOnForBuild(eventDto.getToPutOnForBuild());

// ACTION SELL GET 3 GOLD
        if (sellCard(currentEvent.getUserActionOnCard())) {
            currentEvent.setGoldChange(3);
        } else {

// EXCEPTION IF USER WANT BUILD DUPLICATE ***
            for (GameCard builtCard : gameBoardView.getCurrentUserBuildCard()) {
                if (builtCard.equals(currentEvent.getCard())
                        && GameUserInfoUtils.build(currentEvent.getUserActionOnCard())
// *** FOR BUILD AND CHAIN
                        || builtCard.equals(currentEvent.getCard())
                        && GameUserInfoUtils.buildZeus(currentEvent.getUserActionOnCard())
// *** FOR ZEUS
                        || builtCard.equals(currentEvent.getCard())
                        && buildChain(currentEvent.getChainCard())
// *** FOR MAUSOLEUM
                        || builtCard.equals(currentEvent.getCard())
                        && buildGalicarnas(currentEvent.getUserActionOnCard())) {
                    throw new RuntimeException("You want buil duplicate");
                }
//END EXCEPTION IF USER WANT BUILD DUPLICATE ***

// DO ACTIVE OR NOT, USER CAN BUILD BY CHAIN
                if (buildChain(currentEvent.getChainCard())
                        && checkCorrectChain(currentEvent.getCard(), currentEvent.getChainCard())) {
                    if (builtCard.equals(currentEvent.getChainCard())) {
                        currentUserGameInfo.setCanBuildByChainCurrentCard(true);
                    }
                }
            }
//EXCEPTION IF USER WANT BUILD WHEN NO HAVE PARENT CARD FOR CHAIN
            if (buildChain(currentEvent.getChainCard())
                    && !currentUserGameInfo.isCanBuildByChainCurrentCard()) {
                throw new RuntimeException("You no can build by chain");
            }
//EXCEPTION IF USER WANT BUILD WHEN ZEUS POWER NO ACTIVE OR HE USE BEFORE IN THIS AGE
            if (GameUserInfoUtils.buildZeus(currentEvent.getUserActionOnCard())
                    && !currentUserGameInfo.isZeusPassiveWonderActive()) {
                throw new RuntimeException("You use pover ZEUS wonder in this age");
            }
//EXCEPTION IF USER WANT RESURRECT BY NOT BUILD CARD BEFORE (IF HAVE PROBLEM HERE PROBLEM WITH LOGIC)
            if (buildGalicarnas(currentEvent.getUserActionOnCard())
                    && !currentUserGameInfo.isBuildGalicarnas()) {
                throw new RuntimeException("You no build GalicarnasAbility in this raund");
            }
//EXCEPTION IF USER WANT BUILD WONDER LEVEL MORE THEN MAX
            if (currentUserGameInfo.getWonderLevel() > currentUserGameInfo.getWonder().getWonderLevelCard().size()) {
                throw new RuntimeException("You want build wonder Level more then max");
            }
/**
 * Build ZEUS,BUILD,CHAIN
 */
// ACTION BUILD CARD OR BUILD WONDER
            if (GameUserInfoUtils.build(currentEvent.getUserActionOnCard())
                    || GameUserInfoUtils.buildWonder(currentEvent.getUserActionOnCard())) {

                List<BaseResource> resourcesNeed = currentEvent.getCard().getResourcesNeedForBuild();
                List<ResourceChooseDto> resourceChooseDtos = eventDto.getResourceChooseDtoList();
                List<PayDto> payDtoList = eventDto.getPayDtoList();
//EXCEPTION NOT HAVE ENOUGH MONEY
                if (currentUserGameInfo.getUserGold() - currentEvent.getCard().getGoldNeededForConstruction() < 0) {
                    throw new RuntimeException("You no have gold for constraction");
                } else {
//SET CHANGE GOLD FOR PAY FOR CONSTRUCTION
                    currentEvent.setGoldChange(currentEvent.getCard().getGoldNeededForConstruction());
                    if (resourcesNeed.size() > 0) {
//EXCEPTION IF NEED RESOURCE BUT NOT CHOOSE
                        if (resourceChooseDtos.size() == 0 & payDtoList.size() == 0) {
                            throw new RuntimeException("You no can build this card, no choose resource for build");
                        }

                        GameUserInfo leftUserInfo = gameBoardView.getLeftSiteUser();
                        GameUserInfo rightUserInfo = gameBoardView.getRightSiteUser();
// BASIC RESOURCE COST IN GAME
                        int buyBrouwnLeft = 2;
                        int buyBrouwnRight = 2;
                        int buySilver = 2;
//*** SET ANOTHER COST IF HAVE SPECIAL CARD
                        if (currentUserGameInfo.isTradeBrownLeft()) {
                            buyBrouwnLeft = 1;
                        }
                        if (currentUserGameInfo.isTradeBrownRight()) {
                            buyBrouwnRight = 1;
                        }
                        if (currentUserGameInfo.isTradeSilverRightAndLeft()) {
                            buySilver = 1;
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
                            if (payDto.getActionSide().equals(ActionSide.LEFT)) {

                                if (!leftUserInfo.getUserBuiltCards().contains(payDto.getGameCard())) {
                                    throw new RuntimeException("Left player no have card whis this name" + payDto.getGameCard());
                                } else {
                                    userChooseTrueResourcesByCardPay(payDto);
                                    if (payDto.getGameCard().getGameCardColor().equals(GameCardColor.BROWN)) {
                                        goldNeedPayLeft += buyBrouwnLeft;
                                    } else if (payDto.getGameCard().getGameCardColor().equals(GameCardColor.SILVER)) {
                                        goldNeedPayLeft += buySilver;
                                    }
                                    if (currentUserGameInfo.getUserGold() - (goldNeedPayLeft + goldNeedPayRight) < 0) {
                                        throw new RuntimeException("Need more gold more buying resourse");
                                    }
                                    allChooseResource.addAll(payDto.getBuyResourceList());
                                }

                            } else if (payDto.getActionSide().equals(ActionSide.RIGHT)) {
                                if (!rightUserInfo.getUserBuiltCards().contains(payDto.getGameCard())) {
                                    throw new RuntimeException("right player no have card whis this name" + payDto.getGameCard());
                                } else {
                                    userChooseTrueResourcesByCardPay(payDto);
                                    if (payDto.getGameCard().getGameCardColor().equals(GameCardColor.BROWN)) {
                                        goldNeedPayRight += buyBrouwnRight;
                                    } else if (payDto.getGameCard().getGameCardColor().equals(GameCardColor.SILVER)) {
                                        goldNeedPayRight += buySilver;
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





