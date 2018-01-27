package com.wonder.wonder.jms;

import lombok.Getter;

@Getter
public enum Items {


    WAR_LOOSE_FIRST(1, -1),

    WAR_LOOSE_SECOND(2, -1),

    WAR_LOOSE_THIRD(3, -1),

    WAR_WIN_FIRST(1, 1),

    WAR_WIN_SECOND(2, 3),

    WAR_WIN_THIRD(3, 5);

    private final int age;

    private final int givePoint;

    Items(int giveForAge, int givePoint) {
        this.age = giveForAge;
        this.givePoint = givePoint;
    }
}
