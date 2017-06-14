package com.wonder.wonder.rest;


import com.wonder.wonder.model.Cards;
import com.wonder.wonder.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Creator: bm
 * Date: 07.06.17.
 */
// Class example
@RestController
public class CardsRestController {
    @Autowired
    private CardService cardsService;

    @RequestMapping("/cards")
    public List<Cards> list(){
        return cardsService.getAllCards();
    }

}
