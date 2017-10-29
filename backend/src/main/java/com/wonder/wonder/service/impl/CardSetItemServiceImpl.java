package com.wonder.wonder.service.impl;

import com.wonder.wonder.dao.CardSetItemDao;
import com.wonder.wonder.model.CardSetItem;
import com.wonder.wonder.service.CardSetItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
  Created by bm on 22.07.17.
 */
@Component
public class CardSetItemServiceImpl implements CardSetItemService {

    private CardSetItemDao cardSetItemDao;

    @Autowired
    public CardSetItemServiceImpl(CardSetItemDao cardSetItemDao) {
        this.cardSetItemDao = cardSetItemDao;
    }

    @Override
    public void save(CardSetItem cardSetItem) {
        cardSetItemDao.save(cardSetItem);
    }
}
