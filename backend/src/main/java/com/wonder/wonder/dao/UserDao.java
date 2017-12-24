package com.wonder.wonder.dao;

import com.wonder.wonder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
public interface UserDao extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findById(long id); // here must be long or Long ??

    Optional<User> findByUserName(String userName);

    @Query("from User")
    List<User> hibernateQuery();


}
