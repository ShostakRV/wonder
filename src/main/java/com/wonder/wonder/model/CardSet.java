package com.wonder.wonder.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
//import org.hibernate.annotations.Table;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Creator: Pavlenko Bohdan
 * Date: 16.06.2017
 * Project: wonder
 */
@Getter
@Setter
@Entity
@Table(name = "card_set")
public class CardSet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

    protected Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Column(name = "set_number")
    protected Integer setNumber;

    @Column(name = "age")
    protected String age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardSet cardSet = (CardSet) o;

        return id.equals(cardSet.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    protected Set<CardSetItem> cardSetItems = new HashSet<CardSetItem>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "card_set")
    public Set<CardSetItem> getCardSetItems() {
        return this.cardSetItems;
    }
}
