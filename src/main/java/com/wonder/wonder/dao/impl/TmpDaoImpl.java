package com.wonder.wonder.dao.impl;

import com.wonder.wonder.dao.TmpDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@Component
public class TmpDaoImpl implements TmpDao {

    protected final Log logger = LogFactory.getLog(getClass());

    @PostConstruct
    public void init() {
        logger.info("TmpDaoImpl has been created!");
    }

    @Override
    public String getSomeValue() {
        return "message ";
    }
}
