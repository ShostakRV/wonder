package com.wonder.wonder.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.12.2017
 * Project: wonder
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class UserDto {
    private long id;
    private String userName;
}
