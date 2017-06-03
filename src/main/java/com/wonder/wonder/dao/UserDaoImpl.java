package com.wonder.wonder.dao;

import com.wonder.wonder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
//@Component
public abstract class UserDaoImpl
//        extends SimpleJpaRepository<User, Long> implements UserDao
{

//    private final EntityManager em;
//
//    @Autowired
//    public UserDaoImpl(EntityManager em) {
//        super(User.class, em);
//        this.em = em;
//    }


//    @Override
//    public List<User> hibernateQuery() {
//        String hql = "from User";
//        return em.createQuery(hql, User.class).getResultList();
//    }

}
