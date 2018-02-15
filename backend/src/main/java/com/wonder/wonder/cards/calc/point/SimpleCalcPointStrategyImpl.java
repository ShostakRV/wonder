package com.wonder.wonder.cards.calc.point;

import com.wonder.wonder.service.util.GameBoardView;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created: godex
 * DATE: 20.06.17.
 */
@Data
@AllArgsConstructor
public class SimpleCalcPointStrategyImpl implements CalcPointStrategy {
    final int points;

    @Override
    public int getPoints(GameBoardView boardView) {
        return points;
    }
}
