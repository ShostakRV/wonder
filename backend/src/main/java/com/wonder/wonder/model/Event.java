package com.wonder.wonder.model;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.phase.UserActionOnCard;
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
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    protected Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_in_game_id", nullable = false)
    protected UserInGame userInGame;

    @Enumerated(EnumType.STRING)
    @Column(name = "phase_game")
    protected GamePhase gamePhase;

    @Column(name = "phase_age_war")
    private Integer PhaseAgeWar;

    @Column(name = "phase_round")
    protected Integer phaseRound;

    @Column(name = "phase_choose_do")
    protected Integer phaseChooseDo;

    @Enumerated(EnumType.STRING)
    @Column(name = "card")
    protected GameCard card;

    @Enumerated(EnumType.STRING)
    @Column(name = "chain_card")
    protected GameCard chainCard;

    // карта за яку будують
    @Column(name = "to_put_on_for_build")
    private GameCard ToPutOnForBuild;

    @Column(name = "action_name")
    @Enumerated(EnumType.STRING)
    protected UserActionOnCard userActionOnCard;

    @Column(name = "gold_change")
    protected Integer goldChange;

    @Column(name = "debt")
    protected Integer debt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}
