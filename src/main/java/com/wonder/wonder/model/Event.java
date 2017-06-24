package com.wonder.wonder.model;

import com.wonder.wonder.cards.GameCard;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Creator: Pavlenko Bohdan
 * Date: 16.06.2017
 * Project: wonder
 */
@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    protected Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    protected User user;

    @Column(name = "action_name")
    protected String actionName;

    @Column(name = "phase")
    protected String phase;

    @Enumerated(EnumType.STRING)
    @Column(name = "card")
    protected GameCard card;

    @Enumerated(EnumType.STRING)
    @Column(name = "chain_card")
    protected GameCard chainCard;

    @Column(name = "gold_change")
    protected Integer goldChange;

    @Column(name = "debt")
    protected Integer debt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        return id.equals(event.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
