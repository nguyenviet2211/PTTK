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
public class Restaurant {
    private int id;
    private String name;
    private String address;
    private String description;
    private String phoneNumber;
    private ArrayList<Table> table;
    private ArrayList<Staff> staff;

    public Restaurant() {
    }

    public Restaurant(int id, String name, String address, String description, String phoneNumber, ArrayList<Table> table, ArrayList<Staff> staff) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.table = table;
        this.staff = staff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Table> getTable() {
        return table;
    }

    public void setTable(ArrayList<Table> table) {
        this.table = table;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<Staff> staff) {
        this.staff = staff;
    }
    
    
}
