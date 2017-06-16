package com.wonder.wonder.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * Creator: Pavlenko Bohdan
 * Date: 16.06.2017
 * Project: wonder
 */
@Entity
@Data
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;
    @Column(name = "phase")
    protected String phase;

    @Column(name = "start")
    protected Date start;    //todo cheack

    @Column(name = "end")
    protected Date end;    //todo cheack

    @Column(name = "players")
    protected Integer players;
}
