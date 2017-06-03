package com.wonder.wonder.dao.impl;

import com.wonder.wonder.dao.TmpDao;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@Component
public class TmpDaoImpl implements TmpDao {

    @PostConstruct
    public void init() {
        System.out.println("TmpDaoImpl has been created!");
    }

    @Override
    public String getSomeValue() {
        return "message ";
    }
}
