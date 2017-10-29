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

        for (MainCard mainCard : MainCard.values()) {
            if (mainCard.getChain() != null) {
                for (String chainName : mainCard.getChain()) {
                    assertNotNull(mainCard + " Not found chain=>" + chainName, MainCard.valueOf(chainName));
                }
            }

        }
    }
}
