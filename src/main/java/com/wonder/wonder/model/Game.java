package com.wonder.wonder.model;

import com.wonder.wonder.businessLogic.GamePhase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    protected long id;
    @Column(name = "phase")
    @Enumerated(EnumType.STRING)
    protected GamePhase phase;


    // game name create

    @Column(name = "start", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date start;

    @Column(name = "end", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date end;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game") //, cascade = CascadeType.ALL example
    protected List<UserInGame> userInGames = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
    protected List<Event> events = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
    protected List<CardSet> cardSets = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        return id == game.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

}
