package com.wonder.wonder.service.util;

import java.util.List;

public class GameBoardFinishPointsView {

    private final List<UserGamePointsInfo> userGamePointsInfoList;
    private long currentUserId;

    public GameBoardFinishPointsView(long currentUserId, List<UserGamePointsInfo> userGamePointsInfoList) {
        this.currentUserId = currentUserId;
        this.userGamePointsInfoList = userGamePointsInfoList;
    }
}
