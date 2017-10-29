package com.wonder.wonder.dto;

import com.wonder.wonder.cards.BaseResource;
import com.wonder.wonder.cards.MainCard;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by bm on 10.08.17.
 */
@Getter
@Setter
public class ResourceChooseDto {

    private MainCard card;
    private List<BaseResource> resourceChoose;

}
