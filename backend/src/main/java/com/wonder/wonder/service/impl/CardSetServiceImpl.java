package com.wonder.wonder.service.impl;

import com.wonder.wonder.dao.CardSetDao;
import com.wonder.wonder.model.CardSet;
import com.wonder.wonder.service.CardSetService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by bm on 20.07.17.
 */
@Component
public class CardSetServiceImpl implements CardSetService {

    private CardSetDao cardSetDao;

    public CardSetServiceImpl(CardSetDao cardSetDao) {
        this.cardSetDao = cardSetDao;
    }

    @Override
    public List<CardSet> getListCardSetByGameId(long gameId) {
        return cardSetDao.findAllByGameId(gameId);
    }

    @Override
    public void save(CardSet cardSet) {
        cardSetDao.save(cardSet);
    }

    @Override
    public CardSet findById(Long cardSetId) {
        return cardSetDao.findById(cardSetId).get();
    }
}
