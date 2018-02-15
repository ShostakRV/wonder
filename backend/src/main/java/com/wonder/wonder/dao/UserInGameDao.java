package com.wonder.wonder.dao;


import com.wonder.wonder.model.UserInGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Arrays;
import java.util.List;

/**
  Created by bm on 11.07.17.
 */
public interface UserInGameDao extends JpaRepository<UserInGame, Long> {
    UserInGame findById(long id);

    List<UserInGame> findAllByGameId(long gameId);

    UserInGame findByGameId(long gameId);

    UserInGame findByIdAndGameId(Long userInGameId, Long gameId);
}
