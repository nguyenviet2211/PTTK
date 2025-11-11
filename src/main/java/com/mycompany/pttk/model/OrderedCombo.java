/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pttk.model;

import java.util.*;
/**
 *
 * @author viet5
 */
public class OrderedCombo {
    private int id;
    private int quantity;
    private Date date;
    private Combo combo;

    public OrderedCombo() {
    }

    public OrderedCombo(int id, int quantity, Date date, Combo combo) {
        this.id = id;
        this.quantity = quantity;
        this.date = date;
        this.combo = combo;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }
    
    
}
