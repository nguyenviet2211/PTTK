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
public class Dish {
    private int id;
    private String name;
    private float price;
    private String description;
    private String ingredient;
    private boolean status;
    private String imgPath;


    public Dish() {
    }

    public Dish(int id, String name, float price, String description, String ingredient, boolean status, String imgpath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.ingredient = ingredient;
        this.status = status;
        this.imgPath = imgpath;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = !(status == 0);
    }
    
    
}
