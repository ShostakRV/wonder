package com.wonder.wonder.model;

import javax.persistence.*;

/**
 * Creator: Pavlenko Bohdan
 * Date: 16.06.2017
 * Project: wonder
 */
@Entity
@Table(name = "user_in_game")
public class UserInGame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

    @Column(name = "user_id")
    protected Long userID;//todo get Object maybe

    @Column(name = "game_id")
    protected Long gameID;//todo get Object maybe

    @Column(name = "wonder")
    protected String wonder;//todo get Object maybe

    @Column(name = "position")
    protected Integer position;

    @Column(name = "p_gold")
    protected Double pGold;

    @Column(name = "p_wars")
    protected Integer pWars;

    @Column(name = "p_wonder")
    protected Integer pWonder;

    @Column(name = "p_blue")
    protected Integer pBlue;

    @Column(name = "p_yellow")
    protected Integer pYellow;

    @Column(name = "p_green")
    protected Integer pGreen;

    @Column(name = "p_purple")
    protected Integer pPurple;

    @Column(name = "p_debt")
    protected Integer pDebt;

}
