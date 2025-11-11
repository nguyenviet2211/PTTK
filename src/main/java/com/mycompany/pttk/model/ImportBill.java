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
public class ImportBill {
    private int id;
    private String billId;
    private ArrayList<IngredientImport> listIngredient;
    private WarehouseStaff staff;

    public ImportBill() {
    }

    public ImportBill(int id, String billId, ArrayList<IngredientImport> listIngredient, WarehouseStaff staff) {
        this.id = id;
        this.billId = billId;
        this.listIngredient = listIngredient;
        this.staff = staff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public ArrayList<IngredientImport> getListIngredient() {
        return listIngredient;
    }

    public void setListIngredient(ArrayList<IngredientImport> listIngredient) {
        this.listIngredient = listIngredient;
    }

    public WarehouseStaff getStaff() {
        return staff;
    }

    public void setStaff(WarehouseStaff staff) {
        this.staff = staff;
    }
    
    
    
}
