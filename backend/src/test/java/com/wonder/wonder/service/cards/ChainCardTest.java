package com.wonder.wonder.service.cards;

import com.wonder.wonder.cards.GameCard;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChainCardTest {
    @Test
    public void getAllCards_3Players_1age() {
        Set<String> names = new TreeSet<>();
        for (GameCard gC : GameCard.values()) {
            names.add(gC.toString());
        }
        for (GameCard gameCard : GameCard.values()) {
            if (gameCard.getChain() != null) {
                for (String chainName : gameCard.getChain()) {
                    assertEquals(true, names.contains(chainName.toString()), gameCard + " Not found chain=>" + chainName);
                }
            }
        }
    }
}
