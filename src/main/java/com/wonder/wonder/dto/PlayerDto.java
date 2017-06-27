package com.wonder.wonder.dto;

import com.wonder.wonder.cards.BaseResource;
import com.wonder.wonder.cards.CardWonder;
import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.PassiveAbility;

import java.util.List;

/**
 * Created by bm
 * DATE 27.06.17.
 */
public class PlayerDto {
    private long playerId;
    private String playerName;
    private int position; // possition player on board
    private int phase;// phase event need rebuild  (or true is 1 and false is 0) or other field
    private EventDto event;// what do player this card
    private List<GameCard> cardSet; // cards on hand for raund

    // need write enum for wonder start passive ability or property

    private List<CardWonder> wonder; // at start give player two card for choose
    private List<GameCard> cardBuild; // card what was build
    private List<BaseResource> resourcesHave; // resource what have player on start raund
    private List<PassiveAbility> passiveAbilities;
    private int gold;
    private int buyResouceLeft; // price for buy resource left player
    private int buyResoueceRight;// price for buy resource right player

    private int warPoint;




}
