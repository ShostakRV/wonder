package com.wonder.wonder.service;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.model.CardSet;
import com.wonder.wonder.model.CardSetItem;

/**
 * Created by bm on 22.07.17.
 */
public interface CardSetItemService {

    CardSetItem findByCardSetAndGameCard(CardSet cardSet, GameCard gameCard);

    void save(CardSetItem cardSetItem);
}
