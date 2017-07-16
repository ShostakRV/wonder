package com.wonder.wonder.dao;

import com.wonder.wonder.businessLogic.GamePhase;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by bm
 * DAte 27.06.17.
 */
public interface GameDao extends PagingAndSortingRepository<Game, Long> {

    Game findById(long id);

    List<Game> findAllByPhase(GamePhase phase);

    @Query("from Game")
    List<Game> hibernateQuery();
}
