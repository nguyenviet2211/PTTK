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
public class SalesStaff extends Staff {
    public SalesStaff() {
    }

    public SalesStaff(String position, int id, String name, String userName, String password, Date datefBirth, String address, String phoneNumber, String role, String note, String email) {
        super(position, id, name, userName, password, datefBirth, address, phoneNumber, role, note, email);
    }
}
