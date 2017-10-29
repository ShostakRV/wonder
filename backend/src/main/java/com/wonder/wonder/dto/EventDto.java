package com.wonder.wonder.dto;

import com.wonder.wonder.cards.BaseResource;
import com.wonder.wonder.cards.MainCard;
import com.wonder.wonder.phase.EventPhaseUserChoose;
import lombok.Data;

import java.util.List;

/**
 * Created by bm
 * DATE 27.06.17.
 */
@Data
public class EventDto {

    private EventPhaseUserChoose eventUserChoose;
    private MainCard playCard;
    private MainCard chainCard;

    private List<PayDto> payDtoList;
    private List<ResourceChooseDto> resourceChooseDtoList;

    private Integer userInGameId; // or you think take user in session


}
