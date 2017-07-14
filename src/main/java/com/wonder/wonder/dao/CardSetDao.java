package com.wonder.wonder.dao;

import com.wonder.wonder.model.CardSet;
import com.wonder.wonder.model.Game;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by bm on 13.07.17.
 */
public interface CardSetDao {
    CardSet findById(Long id);

    CardSet findByPhase(Long id);

    @Query("from CardSet")
    List<CardSet> hibernateQuery();
}
