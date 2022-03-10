package com.wonder.wonder.cards;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created: godex
 * DATE: 22.06.17.
 */
public class ChainCardTest {
    @Test
    public void getAllCards_3Players_1age() {

        for (GameCard mainCard : GameCard.values()) {
            if (mainCard.getChain() != null) {
                for (String chainName : mainCard.getChain()) {
                    assertNotNull(GameCard.valueOf(chainName), mainCard + " Not found chain=>" + chainName);
                }
            }

        }
    }

    @Test
    @Disabled
    public void ss() {
        String s1 = new String(new char[]{'s', 's'});
        String s2 = "exeptionNoCanBuildByChain";
        if (s1 == s2) {

        }
        assertTrue(s1 == s2);
    }
}
