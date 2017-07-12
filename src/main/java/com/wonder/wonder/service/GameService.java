package com.wonder.wonder.service;

import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.User;
import com.wonder.wonder.model.UserInGame;
import org.springframework.security.core.Authentication;

import java.util.List;

/**
 * Created by bm
 * DAte 27.06.17.
 */
public interface GameService {


    void createGame(Long userId,Integer players );

    List<Game> showLobby();

    boolean joinToGame(Long gameId, Authentication Authentication);

    void userStartGameFullGame(Long gameId);

    void save(Game game);



}
