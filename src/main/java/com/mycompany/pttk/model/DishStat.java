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
public class DishStat extends Dish{
    private float total;

    public DishStat() {
    }

    public DishStat(float total, int id, String name, float price, String description, String ingredient, boolean status, String imgpath) {
        super(id, name, price, description, ingredient, status, imgpath);
        this.total = total;
    }
    
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
}
