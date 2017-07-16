package com.wonder.wonder.dao;

import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.Game;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by bm on 13.07.17.
 */
public interface EventDao {

    Event findById(long id);



    @Query("from Event")
    List<Event> hibernateQuery();
}
