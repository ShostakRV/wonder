package com.wonder.wonder.dao;

import com.wonder.wonder.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
public interface UserDao extends PagingAndSortingRepository<User, Long> {
    List<User> findByUserName(String name);

    User findByEmail(String email);

    @Query("from User")
    List<User> hibernateQuery();
}
