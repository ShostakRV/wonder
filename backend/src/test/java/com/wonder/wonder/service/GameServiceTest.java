package com.wonder.wonder.service;

import com.wonder.wonder.TestData.service.GameFactory;
import com.wonder.wonder.TestData.service.UserFactory;
import com.wonder.wonder.TestData.service.UserInGameFactory;
import com.wonder.wonder.cards.WonderCard;
import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.dao.GameDao;
import com.wonder.wonder.dto.GameViewDto;
import com.wonder.wonder.model.*;
import com.wonder.wonder.phase.GamePhase;

import com.wonder.wonder.service.impl.GameServiceImpl;
import com.wonder.wonder.util.AuthenticationWrapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.internal.verification.Times;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

/**
 * Created by bm on 27.06.17.
 */
//
//стаешь на локальный мастер... git checkout master
//        git merge origin/<название свого бранча> --squash --no-commit
@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    private static final long GAME_ID = 1L;

    @Mock
    private GameDao gameDao;

    @InjectMocks
    @Spy
    private GameServiceImpl gameServiceImpl;

    @Mock
    private UserInGameService userInGameService;

    @Mock
    private UserService userService;

    @Mock
    private AuthenticationWrapper authenticationWrapper;

    @Mock
    private CardSetService cardSetService;

    @Mock
    private CardSetItemService cardSetItemService;

    private static String GAME_NAME = "GameName";

    @Before
    public void setUp() throws Exception {
        System.out.println();
    }

    @Test
    public void createGameSuccessfulTest() {
        doReturn(true).when(gameServiceImpl).joinToGame(anyLong());
        gameServiceImpl.createGame(GAME_NAME);
        ArgumentCaptor<Game> argumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameDao, new Times(1)).save(argumentCaptor.capture());
        verify(gameServiceImpl, new Times(1)).joinToGame(anyLong());
        Game game = argumentCaptor.getValue();
        assertEquals(GamePhase.JOIN_PHASE, game.getPhaseGame());
        assertEquals("GameName",game.getName());
    }


    @Test(expected = RuntimeException.class)
    public void createGameValidIdTest() {
        when(authenticationWrapper.getCurrentUser()).thenReturn(UserFactory.currentUserInit());
            gameServiceImpl.createGame(GAME_NAME);
    }

    @Test
    public void joinToGameSuccessfulTest() {
        when(authenticationWrapper.getCurrentUser()).thenReturn(UserFactory.currentUserInit());
        User user = authenticationWrapper.getCurrentUser();
        when(userInGameService.getAllUserInGameByGameId(GAME_ID)).
                thenReturn(UserInGameFactory.listUserInGameInit(1, GAME_ID));
        when(gameDao.findById(GAME_ID)).thenReturn(GameFactory.gameInit(GAME_ID, 1, GamePhase.JOIN_PHASE));
        when(userService.getUserById(user.getId())).thenReturn(UserFactory.currentUserInit());
        boolean result = gameServiceImpl.joinToGame(GAME_ID);

        ArgumentCaptor<UserInGame> userInGameArgumentCaptor = ArgumentCaptor.forClass(UserInGame.class);
        verify(userInGameService, new Times(1)).save(userInGameArgumentCaptor.capture());
        UserInGame userInGame = userInGameArgumentCaptor.getValue();
        assertEquals(userInGame.getUser().getId(), user.getId());

        assertEquals(userInGame.getGame().getId(), GAME_ID);
        assertEquals(userInGame.getGame().getPhaseGame(), GamePhase.JOIN_PHASE);

        assertEquals(true, result);
    }

    @Test(expected = RuntimeException.class)
    public void joinInGameFullGameTest() {
        when(userInGameService.getAllUserInGameByGameId(GAME_ID).size()).thenReturn((14));
            gameServiceImpl.joinToGame(GAME_ID);
    }

    @Test(expected = RuntimeException.class)
    public void joinInNoExistGameTest() {
        when(gameDao.findById(GAME_ID)).thenReturn(null);
            gameServiceImpl.joinToGame(GAME_ID);
    }

    @Test(expected = RuntimeException.class)
    public void userInGameTryToJoinGameAgainTest() {
        when(userInGameService.getUserInGameByGameId(GAME_ID)).thenReturn(new UserInGame());
        doReturn(true).when(gameDao).findById(anyLong());
            gameServiceImpl.joinToGame(GAME_ID);
    }

    // do dto this field which we need
    @Test
    public void getGameforShowInLobbyTest() {
        List<Game> gameList = GameFactory.gameInitListPhaseJoin_Phase();
        doReturn(gameList).when(gameDao).findAllByPhaseGame(GamePhase.JOIN_PHASE);
        List<GameViewDto> gameViewDtoList = gameServiceImpl.showGameInJoinPhaseInLobby();
        for (int i = 0; i < gameList.size(); i++) {
            GameViewDto viewDto = gameViewDtoList.get(i);
            Game game = gameList.get(i);
            assertEquals(game.getId(), viewDto.getGameId());
            assertEquals(game.getName(), viewDto.getGameName());
            assertEquals(game.getUserInGames().size(), viewDto.getPlayersInGameCount());
        }


    }

//    public List<GameViewDto> showLobbyDtoListInit() {
//        List<Game> gameList = GameFactory.gameInitListPhaseJoin_Phase();
//        List<UserInGame> userInGameList = listUserInGameInit(3, 103L);
//        List<GameViewDto> gameViewDtoList = new ArrayList<>();
//        gameViewDtoList.forEach(gameViewDto -> gameViewDto.setPlayersInGameCount(
//                userInGameList.size()));
//        return null;
//    }

    @Test(expected = RuntimeException.class)
    public void userStartGameNoHaveFourUserTest() {
        Game gameMock = GameFactory.gameInit(GAME_ID, 2, GamePhase.JOIN_PHASE);
        when(gameDao.findById(GAME_ID)).thenReturn(gameMock);
            gameServiceImpl.startGame(GAME_ID);

    }

    @Test
    public void userStartGameFullGameSuccsessfulMetodStartGameTest() {
        Game gameMock = GameFactory.gameInit(GAME_ID, 4, GamePhase.JOIN_PHASE);
        List<UserInGame> userInGameList = gameMock.getUserInGames();
        when(gameDao.findById(GAME_ID)).thenReturn(gameMock);
       gameServiceImpl.startGame(GAME_ID);
        ArgumentCaptor<Game> argumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameDao, new Times(1)).save(argumentCaptor.capture());
        Game game = argumentCaptor.getValue();
        assertEquals(GamePhase.AGE_1, game.getPhaseGame());
        assertEquals(new Integer(1),game.getPhaseRound());
        assertEquals(new Integer(1),game.getPhaseChooseDo());
        assertEquals(userInGameList.size(), game.getUserInGames().size());
    }

    @Test
    public void correctSaveSetCardMetodStartGameTest() {
        Game game = GameFactory.gameInit(GAME_ID, 4, GamePhase.JOIN_PHASE);
        when(userInGameService.getAllUserInGameByGameId(GAME_ID)).
                thenReturn(UserInGameFactory.listUserInGameInit(4, GAME_ID));
        when(gameDao.findById(GAME_ID)).thenReturn(GameFactory.gameInit(GAME_ID, 4, GamePhase.JOIN_PHASE));
       gameServiceImpl.startGame(GAME_ID);
        ArgumentCaptor<CardSet> argumentCaptor = ArgumentCaptor.forClass(CardSet.class);
        verify(cardSetService, new Times(4)).save(argumentCaptor.capture());
        List<CardSet> cardSetList = argumentCaptor.getAllValues();
        for (int i = 0; i < cardSetList.size(); i++) {
            CardSet cardSet = cardSetList.get(i);
            Game correctGame = cardSet.getGame();
            assertEquals(game.getId(), correctGame.getId());
            assertEquals(new Integer(i), cardSet.getSetNumber());
        }
    }

    @Test
    public void correctSaveSetCardItemMetodStartGameTest() {
        Game game = GameFactory.gameInit(GAME_ID, 4, GamePhase.JOIN_PHASE);
        when(userInGameService.getAllUserInGameByGameId(GAME_ID)).
                thenReturn(UserInGameFactory.listUserInGameInit(4, GAME_ID));
        when(gameDao.findById(GAME_ID)).thenReturn(GameFactory.gameInit(GAME_ID, 4, GamePhase.JOIN_PHASE));
       gameServiceImpl.startGame(GAME_ID);
        ArgumentCaptor<CardSetItem> argumentCaptor = ArgumentCaptor.forClass(CardSetItem.class);
        verify(cardSetItemService, new Times(28)).save(argumentCaptor.capture());
        List<CardSetItem> cardSetItemList = argumentCaptor.getAllValues();
        assertEquals(28, cardSetItemList.size());
        for (int j = 0; j < cardSetItemList.size(); j++) {
            CardSetItem cardSetItem = cardSetItemList.get(j);
            assertEquals(0 ,cardSetItem.getCardSet().getId());
            assertEquals(null, cardSetItem.getPlayedPhaseChooseDo());
            assertNotEquals(null, cardSetItem.getGameCard());
        }
    }

    // do use set like unique
    // check dublicate field UserInGame
    // check null field UserInGame set

    @Test
    public void allUserInGameHaveWonderAndpositionMetodStartGameTest() {
       when(userInGameService.getAllUserInGameByGameId(GAME_ID)).thenReturn(UserInGameFactory.listUserInGameInit(4, GAME_ID));
        when(gameDao.findById(GAME_ID)).thenReturn(GameFactory.gameInit(GAME_ID, 4, GamePhase.JOIN_PHASE));
      gameServiceImpl.startGame(GAME_ID);
        ArgumentCaptor<Game> argumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameDao, new Times(1)).save(argumentCaptor.capture());
        Game game = argumentCaptor.getValue();
        List<UserInGame> userInGameList = game.getUserInGames();
        Set<WonderCard> correctContWonder = new TreeSet<>();
        Set<Integer> correctCountPosition = new TreeSet<>();
        for (UserInGame userInGame : userInGameList) {
            assertNotEquals(null, userInGame.getWonder());
            assertNotEquals(null, userInGame.getPosition());
            correctContWonder.add(userInGame.getWonder());
            correctCountPosition.add(userInGame.getPosition());
        }
        assertEquals(userInGameList.size(), correctContWonder.size() );
        assertEquals(userInGameList.size(), correctCountPosition.size() );
    }

    @Test
    public void getAllCardByAgeAndNumberPlayersSuccessfulMetodStartGameTest() {
        for (int age = 1; age < 4; age++) {
            for (int playersInGame = 3; playersInGame < 8; playersInGame++) {
                List<GameCard> cards = gameServiceImpl.getAllCardByAgeAndNumberPlayers(age, playersInGame);
                assertEquals(playersInGame * 7, cards.size());
            }
        }
    }
}





