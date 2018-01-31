package com.wonder.wonder.jms;

import lombok.Getter;

@Getter
public enum Items {


    WAR_LOOSE_1(1, -1),

    WAR_LOOSE_2(2, -1),

    WAR_LOOSE_3(3, -1),

    WAR_WIN_1(1, 1),

    WAR_WIN_2(2, 3),

    WAR_WIN_3(3, 5);

    private final int age;

    private final int givePoint;

    Items(int giveForAge, int givePoint) {
        this.age = giveForAge;
        this.givePoint = givePoint;
    }
}
