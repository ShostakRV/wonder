package com.wonder.wonder.rest;

import com.wonder.wonder.rest.dto.HumanDTO;
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

    // Missurenko // metod example
    @RequestMapping("/message/money")// spring mvc
    public String money() {
        return "I take 1000$ per month!";
    }
    // Missurenko
    @RequestMapping(value = "/message/humanDto", method = RequestMethod.GET)// spring mvc
    public List<HumanDTO> test() {
        return Arrays.asList(new HumanDTO("Bob", 20, 'M'),new HumanDTO("Vanessa", 23, 'F'));
    }
    // Missurenko
    @RequestMapping(value = "/message/dto/1/{name}", method = RequestMethod.GET)// spring mvc
    public PairDto listWhisName(@PathVariable String name) {
        return new PairDto( name + " " , tmpService.getSomeString());
    }
    // Missurenko
    @RequestMapping(value = "/message/humanDto/", method = RequestMethod.POST)// spring mvc
    public HumanDTO update(@RequestBody HumanDTO humanDTO) {
        return humanDTO;
    }
    // Missurenko
    @RequestMapping(value = "/message/humanDto/", method = RequestMethod.PUT)// spring mvc
    public HumanDTO save(@RequestBody HumanDTO humanDTO) {
        return humanDTO;
    }




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
