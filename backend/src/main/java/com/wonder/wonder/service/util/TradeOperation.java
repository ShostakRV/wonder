package com.wonder.wonder.service.util;

import lombok.Data;

@Data
public class TradeOperation {

    private int buyBrouwnLeft = 2;
    private int buyBrouwnRight = 2;
    private int buySilver = 2;

    private int goldNeedPayLeft;
    private int goldNeedPayRight;
}
