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
public class Bill {
    private int id;
    private String billId;
    private Date createdTime;
    private float total;

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    private String note;
    private String paymentMethod;
    private ArrayList<OrderedDish> listDish;
    private ArrayList<OrderedCombo> listCombo;
    private Table table;
    private Customer customer;
    private SalesStaff sales;

    public Bill(int id, String billId, Date createdTime, float total, String note, String paymentMethod, ArrayList<OrderedDish> listDish, ArrayList<OrderedCombo> listCombo, Table table, Customer customer, SalesStaff sales) {
        this.id = id;
        this.billId = billId;
        this.createdTime = createdTime;
        this.total = total;
        this.note = note;
        this.paymentMethod = paymentMethod;
        this.listDish = listDish;
        this.listCombo = listCombo;
        this.table = table;
        this.customer = customer;
        this.sales = sales;
    }

    public Bill() {
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

    public void setBillId(String BillId) {
        this.billId = BillId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ArrayList<OrderedDish> getListDish() {
        return listDish;
    }

    public void setListDish(ArrayList<OrderedDish> listDish) {
        this.listDish = listDish;
    }

    public ArrayList<OrderedCombo> getListCombo() {
        return listCombo;
    }

    public void setListCombo(ArrayList<OrderedCombo> listCombo) {
        this.listCombo = listCombo;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer cuatomer) {
        this.customer = cuatomer;
    }

    public SalesStaff getSales() {
        return sales;
    }

    public void setSales(SalesStaff sales) {
        this.sales = sales;
    }
    
    
}
