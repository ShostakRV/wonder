package com.wonder.wonder.model;

import com.wonder.wonder.cards.MainCard;
import com.wonder.wonder.cards.MainCard;
import com.wonder.wonder.phase.GamePhase;
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
@Table(name = "card_set_item")
public class CardSetItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_in_game_id", nullable = false)
    protected UserInGame userInGame;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_set_id", nullable = false)
    protected CardSet cardSet;

    @Enumerated(EnumType.STRING)
    @Column(name = "played_phase_game")
    protected GamePhase playedGamePhase;

    @Column(name = "played_phase_round")
    protected Integer playedPhaseRound;

    @Column(name = "played_phase_choose_do")
    protected Integer playedPhaseChooseDo;

    @Column(name = "card")
    @Enumerated(EnumType.STRING)
    protected MainCard mainCard;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardSetItem cardSetItem = (CardSetItem) o;

        return id == cardSetItem.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}