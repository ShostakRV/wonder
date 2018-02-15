package com.wonder.wonder.dao;

import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.User;
import com.wonder.wonder.phase.GamePhase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by bm on 13.07.17.
 */
public interface EventDao extends JpaRepository<Event, Long> {

    Event findById(long id);

    List<Event> findByGameId(long id);

    @Query("select e from Event e where e.game.id = :gameId and" +
            " e.gamePhase = :gamePhase AND" +
            " e.phaseRound = :phaseRound AND" +
            " e.phaseChooseDo = :phaseChooseDo and" +
            " e.userActionOnCard IS NOT NULL")
    List<Event> getAllLastEvent(@Param("gameId") long gameId,
                                @Param("gamePhase") GamePhase gamePhase,
                                @Param("phaseRound") int phaseRound,
                                @Param("phaseChooseDo") int phaseChooseDo);


    @Query("select e from Event e where e.game.id = :gameId and" +
            " e.gamePhase >= 1 AND" +
            " e.gamePhase <= :gamePhase AND" +
            " e.phaseRound = :phaseRound AND" +
            " e.phaseChooseDo = :phaseChooseDo and" +
            " e.userActionOnCard IS NOT NULL")
    List<Event> getAllRaundLastEvent(@Param("gameId") long gameId,
                                     @Param("gamePhase") GamePhase gamePhase,
                                     @Param("phaseRound") int phaseRound,
                                     @Param("phaseChooseDo") int phaseChooseDo);
}
