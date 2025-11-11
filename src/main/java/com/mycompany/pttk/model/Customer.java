/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pttk.model;

import java.util.Date;

/**
 *
 * @author viet5
 */
public class Customer extends Member{
    private String customerID;
    private String cardId;
    private float point;
    
    
    

    
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    

    public Customer() {
    }   

    public Customer(String customerID, String cardId, float point, int id, String name, String userName, String password, Date datefBirth, String address, String phoneNumber, String role, String note, String email) {
        super(id, name, userName, password, datefBirth, address, phoneNumber, role, note, email);
        this.customerID = customerID;
        this.cardId = cardId;
        this.point = point;
    }
    

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    
    
}
