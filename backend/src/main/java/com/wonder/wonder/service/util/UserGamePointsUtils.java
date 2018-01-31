package com.wonder.wonder.service.util;

import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.UserInGame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserGamePointsUtils {


    public static Map<Long, UserGamePointsInfo> createUserGamePoints(List<Event> eventList) {

        Map<Long, UserGamePointsInfo> mapUserCalculateGame = new HashMap<>();

        for (Event event : eventList) {
            UserInGame userInGame = event.getUserInGame();
            long userInGameId = userInGame.getId();
// CREATE GameUserInfo if no HAVE USER ID LIKE KEY
            UserGamePointsInfo userGamePointsInfo = mapUserCalculateGame.get(userInGameId);
            if (userGamePointsInfo == null) {
                userGamePointsInfo = new UserGamePointsInfo(userInGame);
                mapUserCalculateGame.put(userInGameId, userGamePointsInfo);

            }
        }
//        for (UserInGame userInGame : userInGames) {
//            gameBoardView.setCurrentUser(userInGame.getId());
//            List<GameCard> builtCardByUser = gameBoardView.getCurrentUserBuildCard();
//            for (GameCard builtCard : builtCardByUser) {
//
//
//                boolean purpleCardWarLooseOn;
//
//                int countLoose;
//
//                List<Items> warWinItems = new ArrayList<>();
//
//                Map<ScientistGuild, Integer> countSienties = new HashMap<>();
//
//                //TODO WAR ITEM COUNT
//                if (builtCard.getAge() == 0) {
//                    userInGame.setPWonder(userInGame.getPWonder()
//                            + builtCard.getStrategy().getPoints(gameBoardView));
//                    // TODO MAP COUNTS
//                    countSienties.put(builtCard.getSignScientistGuild(), 1);
//                } else {
//                    if (builtCard.getGameCardColor().equals(GameCardColor.BLUE)) {
//                        userInGame.setPBlue(userInGame.getPBlue() +
//                                builtCard.getStrategy().getPoints(gameBoardView));
//                    } else if (builtCard.getGameCardColor().equals(GameCardColor.YELLOW)) {
//                        userInGame.setPBlue(userInGame.getPBlue() +
//                                builtCard.getStrategy().getPoints(gameBoardView));
//                    } else if (builtCard.getGameCardColor().equals(GameCardColor.PURPLE)) {
//                        userInGame.setPBlue(userInGame.getPBlue() +
//                                builtCard.getStrategy().getPoints(gameBoardView));
//                    } else if (builtCard.getGameCardColor().equals(GameCardColor.GREEN)) {
//// TODO MAP COUNTS
//                    }
//                }
//            }
//
//        }
        return null;
    }
}
