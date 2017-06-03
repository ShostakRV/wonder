package com.wonder.wonder.service.impl;

import com.wonder.wonder.dao.TmpDao;
import com.wonder.wonder.service.TmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@Component
public class TmpServiceImpl implements TmpService {
    private final TmpDao tmpDao;

    @Autowired
    public TmpServiceImpl(TmpDao tmpDao) {
        this.tmpDao = tmpDao;
    }

    @PostConstruct
    public void init() {
        System.out.println("TmpServiceImpl has been created!");
    }


    @Override
    public String getSomeString() {
        return tmpDao.getSomeValue() + System.currentTimeMillis();
    }
}
