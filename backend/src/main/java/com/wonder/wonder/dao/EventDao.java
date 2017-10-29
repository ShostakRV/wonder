package com.wonder.wonder.dao;

import com.wonder.wonder.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by bm on 13.07.17.
 */
public interface EventDao extends PagingAndSortingRepository<Event,Long> {

    Event findById(long id);

    List<Event> findByGameId(long id);



    @Query("from Event")
    List<Event> hibernateQuery();
}
