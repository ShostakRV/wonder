package com.wonder.wonder.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    protected List<UserInGame> userInGames = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    protected List<Event> events = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    protected List<CardSetItem> cardSetItems = new ArrayList<>();

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

}
