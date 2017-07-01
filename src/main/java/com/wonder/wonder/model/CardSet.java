package com.wonder.wonder.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import org.hibernate.annotations.Table;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    protected Game game;

    @Column(name = "set_number")
    protected Integer setNumber;

    @Column(name = "age")
    protected String age;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cardSet")
    protected List<CardSetItem> cardSetItems = new ArrayList<>();

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


}