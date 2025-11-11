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
public class Staff extends Member {
    private String position;

    public Staff() {
    }

    public Staff(String position, int id, String name, String userName, String password, Date datefBirth, String address, String phoneNumber, String role, String note, String email) {
        super(id, name, userName, password, datefBirth, address, phoneNumber, role, note, email);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
}
