package com.wonder.wonder.dto;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.cards.BaseResource;
import com.wonder.wonder.cards.GameCard;
import lombok.Data;

import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 02.07.2017
 * Project: wonder
 */
@Data
public class PayDto {

    private ActionSide actionSide;
    private GameCard gameCard;
    private List<BaseResource> buyResourceList;
}
