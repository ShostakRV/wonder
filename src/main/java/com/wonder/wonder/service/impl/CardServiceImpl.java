package com.wonder.wonder.service.impl;

import com.wonder.wonder.dao.CardsDAO;
import com.wonder.wonder.model.Cards;
import com.wonder.wonder.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Creator: bm
 * Date: 07.06.17.
 */
// Class example
@Component
public class CardServiceImpl implements CardService {

    private final CardsDAO cardsDAO;

    @Autowired
    public CardServiceImpl(CardsDAO cardsDAO) {
        this.cardsDAO = cardsDAO;
    }

    @PostConstruct
    public void init() {
        System.out.println("CardServiceImpl has been created!");
    }

    @Override
    public List<Cards> getAllCards() {
        return StreamSupport.stream(cardsDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}


