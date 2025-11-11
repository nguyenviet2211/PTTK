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
public class CustomerStat extends Customer{
    private Date date;
    private float totalBill;

    public CustomerStat() {
    }

    public CustomerStat(Date date, float totalBill, String customerID, String cardId, int point, int id, String name, String userName, String password, Date datefBirth, String address, String phoneNumber, String role, String note, String email) {
        super(customerID, cardId, point, id, name, userName, password, datefBirth, address, phoneNumber, role, note, email);
        this.date = date;
        this.totalBill = totalBill;
    }

    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(float totalBill) {
        this.totalBill = totalBill;
    }
    
    
}
