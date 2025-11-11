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
public class Member {
    private int id;
    private String name;
    private String userName;
    private String password;
    private Date datefBirth;
    private String address;
    private String phoneNumber;
    private String role;
    private String note;
    private String email;

    public Member() {
    }

    public Member(int id, String name, String userName, String password, Date datefBirth, String address, String phoneNumber, String role, String note, String email) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.datefBirth = datefBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.note = note;
        this.email = email;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDatefBirth() {
        return datefBirth;
    }

    public void setDatefBirth(Date datefBirth) {
        this.datefBirth = datefBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
