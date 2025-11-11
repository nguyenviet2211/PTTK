/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pttk.model;

/**
 *
 * @author viet5
 */
public class Table {
    private int id;
    private int tableNumber;
    private boolean status;
    private int numberOfChair;
    private String type;

    public Table() {
    }

    public Table(int id, int tableNumber, boolean status, int numberOfChair, String type) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.status = status;
        this.numberOfChair = numberOfChair;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status == 1;
    }

    public int getNumberOfChair() {
        return numberOfChair;
    }

    public void setNumberOfChair(int numberOfChair) {
        this.numberOfChair = numberOfChair;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
}
