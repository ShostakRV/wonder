package com.wonder.wonder.cards;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created: godex
 * DATE: 22.06.17.
 */
public class ChainCardTest {
    @Test
    public void getAllCards_3Players_1age() {

        for (GameCard gameCard : GameCard.values()) {
            if (gameCard.getChain() != null) {
                for (String chainName : gameCard.getChain()) {
                    assertNotNull(gameCard + " Not found chain=>" + chainName, GameCard.valueOf(chainName));
                }
            }

        }
    }
}
