package com.feastplanner.menuservice.dto;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "menus")
public class MenuCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user")
    @Email
    private String userEmail;

    @Column(name = "title")
    private String name;

    @Column(name = "note")
    private String note;

    @Column(name = "recipes")
    private String recipes;

    public MenuCard() {
    }

    public MenuCard(String userEmail, String name, String note, String recipes) {
        this.userEmail = userEmail;
        this.name = name;
        this.note = note;
        this.recipes = recipes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRecipes() {
        return recipes;
    }

    public void setRecipes(String recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        return "MenuCard{" +
                "id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", recipes='" + recipes + '\'' +
                '}';
    }
}
