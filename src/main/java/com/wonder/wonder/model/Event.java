package com.wonder.wonder.model;

import com.wonder.wonder.service.cards.resouse_NeedRename.GameCard;
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

    @Column(name = "game_id")
    protected Long gameID;//todo get Object maybe

    @Column(name = "user_id")
    protected Long userID;//todo get Object maybe

    @Column(name = "action_name")
    protected String actionName;

    @Column(name = "phase")
    protected String phase;

    @Column(name = "card")
    @Enumerated
    protected GameCard card;//todo get Object maybe

    @Column(name = "chain_card")
    protected String chainCard;//todo get Object maybe

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
