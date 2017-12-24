package com.wonder.wonder.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

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
    @NotNull
    private String name;
    @Email
    private String email;
    @NotNull
    private String password;
}
