package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 15.04.2016.
 */


public class User {




    @JsonProperty("user_id")
     private long id;

    @Size(min=5)
    @NotEmpty
    @JsonProperty("login")
    private String login;

    @Size(min=5)
    @NotEmpty
    @JsonProperty("password")
    private String password;

    @Size(min=5)
    @NotEmpty
    @JsonProperty("surname")
    private String surname;

    @Size(min=5)
    @NotEmpty
    @JsonProperty("name")
    private String name;

    @Size(min=5)
    @NotEmpty
    @JsonProperty("patronymic")
    private String patronymic;

    @JsonProperty("roles")
    private Set<Role> roles = new HashSet<Role>();



    @JsonProperty("phoneBookItems")
    private Set<PhoneBookItem> phoneBookItems = new HashSet<PhoneBookItem>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Set<PhoneBookItem> getPhoneBookItems() {
        return phoneBookItems;
    }

    public void setPhoneBookItems(Set<PhoneBookItem> phoneBookItems) {
        this.phoneBookItems = phoneBookItems;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", patronymic='").append(patronymic).append('\'');
        sb.append(", roles=").append(roles);
        sb.append(", phoneBookItems=").append(phoneBookItems);
        sb.append('}');
        return sb.toString();
    }
}
