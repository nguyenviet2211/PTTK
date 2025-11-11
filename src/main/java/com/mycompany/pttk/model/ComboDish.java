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
public class ComboDish {
   private int id;
   private int quantity;
   private Dish dish;

    public ComboDish() {
    }

    public ComboDish(int id, int quantity, Dish dish) {
        this.id = id;
        this.quantity = quantity;
        this.dish = dish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
   
   
}
