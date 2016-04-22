package com.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by user on 15.03.2016.
 */

public class Role {

    @JsonProperty("id")
    private long id;

    @JsonProperty("role_name")

    private String roleName = RoleTypes.USER.getUserProfileType();

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append("id=").append(id);
        sb.append(", roleName='").append(roleName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}