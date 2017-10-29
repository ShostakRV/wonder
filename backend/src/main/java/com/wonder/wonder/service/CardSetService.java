package com.wonder.wonder.service;

import com.wonder.wonder.model.CardSet;

import java.util.List;

/**
  Created by bm on 20.07.17.
 */
public interface CardSetService {



    List<CardSet> getListCardSetByGameId(long gameId);

    void save(CardSet cardSet);
}
