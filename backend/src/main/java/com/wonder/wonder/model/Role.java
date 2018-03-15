package com.wonder.wonder.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Creator: bm
 * Date: 20.12.17.
 */
@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Role role = (Role) o;
        return roleId == role.roleId && (name != null ? name.equals(role.name) : role.name == null);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + roleId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
