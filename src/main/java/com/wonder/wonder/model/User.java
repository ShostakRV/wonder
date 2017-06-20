package com.wonder.wonder.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;
    @Column(name = "email")
    protected String email;
    @Column(name = "username")
    protected String userName;
    @Column(name = "password")
    protected String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
