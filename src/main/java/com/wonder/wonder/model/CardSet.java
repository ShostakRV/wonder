package com.wonder.wonder.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
//import org.hibernate.annotations.Table;
import javax.persistence.*;

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

    @Column(name = "game_id")
    protected Long gameId;//todo get Object maybe

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
}
