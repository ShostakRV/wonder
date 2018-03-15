package com.wonder.wonder.dao;

import com.wonder.wonder.model.Game;
import com.wonder.wonder.phase.GamePhase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by bm
 * DAte 27.06.17.
 */
public interface GameDao extends JpaRepository<Game, Long> {

    Game findById(long id);

    List<Game> findAllByPhaseGame(GamePhase phase);

}
