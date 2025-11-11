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
public class SupplierStat extends Supplier{
    private Date date;
    private float total;

    public SupplierStat() {
    }

    public SupplierStat(Date date, float total, int id, String name, String address, String emial, String phoneNumber, String note) {
        super(id, name, address, emial, phoneNumber, note);
        this.date = date;
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
