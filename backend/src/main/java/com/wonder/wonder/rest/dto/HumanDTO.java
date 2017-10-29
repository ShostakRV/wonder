package com.wonder.wonder.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Creator: bm
 * Date: 06.06.17.
 */
// Class example
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor // What do ? Missurenko
public class HumanDTO {
    private String name;
    private int age;
    private char gender;
}
