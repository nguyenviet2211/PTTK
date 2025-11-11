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
public class IngredientStat extends Ingredient{
    private float total;
    private Date date;

    public IngredientStat() {
    }

    public IngredientStat(float total, Date date, int id, String name, String description, String note, String unit) {
        super(id, name, description, note, unit);
        this.total = total;
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
    
}
