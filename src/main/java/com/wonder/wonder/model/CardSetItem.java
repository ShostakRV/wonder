package com.wonder.wonder.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Creator: Pavlenko Bohdan
 * Date: 16.06.2017
 * Project: wonder
 */
@Data
@Entity
@Table(name = "card_set_item")
public class CardSetItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

    @Column(name = "user_id")
    protected Long userId;//todo get Object maybe

    @Column(name = "card_set_id")
    protected Long cardSetId;//todo get Object maybe

    @Column(name = "player_phase")
    protected String playerPhase;

    @Column(name = "card")
    protected String card;    //todo get Object maybe
}