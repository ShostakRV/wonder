package com.wonder.wonder.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * Creator: bm
 * Date: 07.06.17.
 */
// Class example
@Entity
@Table(name = "cards")
@Getter
@Setter
public class Cards {
    //TODO delete maybe

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;
    @Column(name = "color")
    protected String color;
    @Column(name = "name")
    protected String name;
    @Column(name = "resouceBuild")
    protected String resouceBuild;
    @Column(name = "ability")
    protected String ability;

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
