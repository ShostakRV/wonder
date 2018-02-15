package com.wonder.wonder.dao;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.model.CardSet;
import com.wonder.wonder.model.CardSetItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by bm on 22.07.17.
 */
public interface CardSetItemDao extends JpaRepository<CardSetItem, Long> {

    CardSetItem findByCardSetAndGameCard(CardSet cardSet, GameCard gameCard);

}
