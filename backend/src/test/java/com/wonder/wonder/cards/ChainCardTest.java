package com.wonder.wonder.cards;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

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
                    assertNotNull(mainCard + " Not found chain=>" + chainName, GameCard.valueOf(chainName));
                }
            }

        }
    }
    @Test
    public void ss() {
        String s1 = new String(new char[]{'s', 's'});
        String s2 = "exeptionNoCanBuildByChain";
        if(s1 == s2){

        }
        assertTrue(s1 == s2);
    }
}
