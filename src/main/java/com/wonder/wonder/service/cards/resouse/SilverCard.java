package com.wonder.wonder.service.cards.resouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: bm
 * Date: 13.06.17.
 */
// need add count cards +3 +4 +5 +6 +7 people
public enum SilverCard {
    //silver first age + second age 3+3 = 6
    LOOM(SilverCard.LOOM),
    GLASSWORKS(SilverCard.GLASSWORKS),
    PRESS(SilverCard.PRESS);

    private List<Resouse> giveResourse;

    SilverCard(SilverCard silverCard) {
        this.giveResourse = staffresource(silverCard);
    }

    private List<Resouse> staffresource(SilverCard silverCard) {
        List<Resouse> resouses = new ArrayList<>();
        switch (silverCard) {
            case LOOM:
                resouses.add(Resouse.SILK);
                return resouses;
            case GLASSWORKS:
                resouses.add(Resouse.GLASS);
                return resouses;
            case PRESS:
                resouses.add(Resouse.PARCHMENT);
                return resouses;
        }
        return null; // maybe can better
    }

    public List<Resouse> getGiveResourse() {
        return giveResourse;
    }

    public void setGiveResourse(List<Resouse> giveResourse) {
        this.giveResourse = giveResourse;
    }
}
