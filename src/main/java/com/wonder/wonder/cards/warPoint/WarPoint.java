package com.wonder.wonder.cards.warPoint;


import java.util.List;
/**
 * Created bm
 * Date 25.06.17.
 */
public interface WarPoint {

    int getPoints();

    static WarPoint simple(int point) {
        return new SimplePointStrategyImpl(point);
    }



}
