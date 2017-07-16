package com.wonder.wonder.model;

import com.wonder.wonder.cards.GameCard;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * Creator: Pavlenko Bohdan
 * Date: 16.06.2017
 * Project: wonder
 */
@Getter
@Setter
@Entity
@Table(name = "user_in_game")
public class UserInGame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    protected Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    protected User user; // too long іерархия запроса

    @Enumerated(EnumType.STRING)
    @Column(name = "wonder")
    protected GameCard wonder;

    @Column(name = "position")
    protected Integer position;

    @Column(name = "p_gold")
    protected Double pGold;

    @Column(name = "p_wars")
    protected Integer pWars;

    @Column(name = "p_wonder")
    protected Integer pWonder;

    @Column(name = "p_blue")
    protected Integer pBlue;

    @Column(name = "p_yellow")
    protected Integer pYellow;

    @Column(name = "p_green")
    protected Integer pGreen;

    @Column(name = "p_purple")
    protected Integer pPurple;

    @Column(name = "p_debt")
    protected Integer pDebt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInGame userInGame = (UserInGame) o;
        return id == userInGame.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}
