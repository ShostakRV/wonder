package com.wonder.wonder.TestData.service;

import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.service.util.GameUserInfo;

public class GameUserInfoFactory {
    public static GameUserInfo initGameUserInfo() {
        return new GameUserInfo(UserInGameFactory.userInGameInitPhaseAge_1());

    }
}
