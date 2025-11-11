/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pttk.model;

/**
 *
 * @author viet5
 */
public class Ingredient {
    private int id;
    private String name;
    private String description;
    private String note;
    private String unit;

    public Ingredient() {
    }

    public Ingredient(int id, String name, String description, String note, String unit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.note = note;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    
}
