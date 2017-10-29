package com.wonder.wonder.service.impl;

import com.wonder.wonder.dao.TmpDao;
import com.wonder.wonder.service.TmpService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@Component
public class TmpServiceImpl implements TmpService {
    protected final Log logger = LogFactory.getLog(getClass());
    private final TmpDao tmpDao;

    @Autowired
    public TmpServiceImpl(TmpDao tmpDao) {
        this.tmpDao = tmpDao;
    }

    @PostConstruct
    public void init() {
        logger.info("TmpServiceImpl has been created!");
    }

// why if stay here
    // wait(1000); have shut down
    @Override
    public String getSomeString() {

        return tmpDao.getSomeValue() + System.currentTimeMillis();
    }
}
