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
public class IngredientImport {
    private int id;
    private Date importDate;
    private float quantity;
    private float price;
    private Date expiredDate;
    private Ingredient ingredient;
    private Supplier supplier;

    public IngredientImport() {
    }

    public IngredientImport(int id, Date importDate, float quantity, float price, Date expiredDate, Ingredient ingredient, Supplier supplier) {
        this.id = id;
        this.importDate = importDate;
        this.quantity = quantity;
        this.price = price;
        this.expiredDate = expiredDate;
        this.ingredient = ingredient;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
