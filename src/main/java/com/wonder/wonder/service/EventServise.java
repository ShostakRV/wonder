package com.wonder.wonder.service;

import com.wonder.wonder.model.Event;

import javax.smartcardio.Card;

/**
 * Created by bm on 13.07.17.
 */
public interface EventServise {

    void eventInfluence(Event event);

    void buildCard(Card card);

    void sellCard(Card card);

}