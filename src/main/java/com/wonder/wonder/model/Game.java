package com.wonder.wonder.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Creator: Pavlenko Bohdan
 * Date: 16.06.2017
 * Project: wonder
 */
@Getter
@Setter
@Entity
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        return id.equals(game.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
    protected Set<UserInGame> userInGames = new HashSet<UserInGame>(0);


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
    protected Set<Event> events = new HashSet<Event>(0);


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
    protected Set<CardSet> cardSets = new HashSet<CardSet>(0);

}
