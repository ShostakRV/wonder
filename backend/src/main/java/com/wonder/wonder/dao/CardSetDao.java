package com.wonder.wonder.dao;

import com.wonder.wonder.model.CardSet;
import com.wonder.wonder.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

/**
  Created by bm on 13.07.17.
 */
public interface CardSetDao extends JpaRepository<CardSet,Long> {
    Optional<CardSet> findById(long id);



    List<CardSet> findAllByGameId(long gameId);

    @Query("from CardSet")
    List<CardSet> hibernateQuery();


}
