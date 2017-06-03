package com.wonder.wonder.rest;

import com.wonder.wonder.rest.dto.PairDto;
import com.wonder.wonder.service.TmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@RestController// spring mvc
public class FirstRestController {

    @Autowired
    private TmpService tmpService;

    @RequestMapping("/message/hello")// spring mvc
    public String hello() {
        return "Wonder is me!";
    }

    @RequestMapping(value = "/message/dto", method = RequestMethod.GET)// spring mvc
    public List<PairDto> list() {
        return Arrays.asList(new PairDto("Hello", " World"));
    }

    @RequestMapping(value = "/message/dto/{id}", method = RequestMethod.GET)// spring mvc
    public PairDto list(@PathVariable int id) {
        return new PairDto("Hello" + id, tmpService.getSomeString());
    }


    @RequestMapping(value = "/message/dto/{id}", method = RequestMethod.POST)// spring mvc
    public PairDto update(@RequestBody PairDto pairDto) {
        return pairDto;
    }

    @RequestMapping(value = "/message/dto", method = RequestMethod.PUT)// spring mvc
    public PairDto save(@RequestBody PairDto pairDto) {
        return pairDto;
    }
}
