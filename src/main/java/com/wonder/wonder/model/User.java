package com.wonder.wonder.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;
    @Column(name = "email")
    protected String email;
    @Column(name = "username")
    protected String userName;
    @Column(name = "password")
    protected String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    protected Set<UserInGame> userInGames = new HashSet<UserInGame>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<UserInGame> getUserInGames() {
        return this.userInGames;
    }

    protected Set<Event> events = new HashSet<Event>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Event> getEvents() {
        return this.events;
    }

    protected Set<CardSetItem> cardSetItems = new HashSet<CardSetItem>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<CardSetItem> getCardSetItems() {
        return this.cardSetItems;
    }
}
