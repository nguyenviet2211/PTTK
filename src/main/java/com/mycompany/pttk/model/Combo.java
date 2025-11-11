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
public class Combo {
    private int id;
    private String name;
    private float price;
    private Date startTime;
    private Date endTime;
    private boolean status;
    private String description;
    private String imgPath;
    private ArrayList<ComboDish> listDish;

    public Combo() {
    }

    public Combo(int id, String name, float price, Date startTime, Date endTime, boolean status, String description, String imgPath, ArrayList<ComboDish> listDish) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.description = description;
        this.imgPath = imgPath;
        this.listDish = listDish;
    }

    

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<ComboDish> getListDish() {
        return listDish;
    }

    public void setListDish(ArrayList<ComboDish> listDish) {
        this.listDish = listDish;
    }
    
    
}
