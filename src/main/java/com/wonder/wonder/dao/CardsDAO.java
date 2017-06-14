package com.wonder.wonder.dao;

import com.wonder.wonder.model.Cards;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Creator: bm
 * Date: 07.06.17.
// */
// Class example
public interface CardsDAO extends PagingAndSortingRepository<Cards,Long> {
    List<Cards> findByName(String name);



    @Query("from Cards")
    List<Cards>hibernateQuery();


}

