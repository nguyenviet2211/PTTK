/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pttk.DAO;

import com.mycompany.pttk.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author viet5
 */
public class BillDAO extends DAO {
    public BillDAO(){
        
    }
    
    public Bill getBillById(int OrderedDishId){
        Bill b = new Bill();
        
        String sql = "select * from restman.tblbill where id = (select tblBillId from restman.tblordereddish where id = ? limit 1);";
      
        try(Connection con = getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, OrderedDishId);
            
            int TableId = -1, CustomerId = -1, SalesId = -1;
            
            try (ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    b.setId(rs.getInt("id"));
                    b.setBillId(rs.getString("billId"));
                    b.setCreatedTime(rs.getDate("createdTime"));
                    b.setNote(rs.getString("note"));
                    b.setPaymentMethod(rs.getString("paymentMethod"));
                    SalesId = rs.getInt("tblSalesStaffId");
                    CustomerId = rs.getInt("tblCustomerId");
                    TableId = rs.getInt("tblTableId");
                }
            }
            
            if(TableId != -1){
                sql = "select * from restman.tbltable where id = ?;";
                ps = con.prepareStatement(sql);
                ps.setInt(1, TableId);
                Table t = new Table();

                try (ResultSet rs = ps.executeQuery()){
                    while(rs.next()){
                        t.setId(rs.getInt("id"));
                        t.setTableNumber(rs.getInt("tableNumber"));
                        t.setStatus(rs.getInt("status"));
                        t.setNumberOfChair(rs.getInt("numberOfChair"));
                        t.setType(rs.getString("type"));
                    }
                }
                b.setTable(t);
            }
            
            if(CustomerId != -1){
                sql =   "select *\n" +
                        "from restman.tblmember as a join restman.tblcustomer as b\n" +
                        "on a.id = b.`tblMemberId`\n" +
                        "where a.id = ?;";
                ps = con.prepareStatement(sql);
                ps.setInt(1, CustomerId);
                
                Customer c = new Customer();
                
                try (ResultSet rs = ps.executeQuery()){
                    while(rs.next()){
                        c.setId(rs.getInt("id"));
                        c.setName(rs.getString("name"));
                        c.setUserName(rs.getString("userName"));
                        c.setPassword(rs.getString("password"));
                        c.setDatefBirth(rs.getDate("dateOfBirth"));
                        c.setAddress(rs.getString("address"));
                        c.setPhoneNumber(rs.getString("phoneNumber"));
                        c.setRole(rs.getString("role"));
                        c.setNote(rs.getString("note"));
                        c.setEmail(rs.getString("email"));
                        c.setCustomerID(rs.getString("customerId"));
                        c.setCardId(rs.getString("cardId"));
                        c.setPoint(rs.getInt("point"));
                    }
                }
                b.setCustomer(c);
            }
            
            if(SalesId != -1){
                sql =   "select *\n" +
                        "from \n" +
                        "restman.tblmember as a \n" +
                        "join restman.tblstaff as b on a.id = b.`tblMemberId`\n" +
                        "join restman.tblsalesstaff as c on c.`tblMemberId` = b.`tblMemberId`\n" +
                        "where a.id = ?;";
                ps = con.prepareStatement(sql);
                ps.setInt(1, SalesId);
                
                SalesStaff c = new SalesStaff();
                
                try (ResultSet rs = ps.executeQuery()){
                    while(rs.next()){
                        c.setId(rs.getInt("id"));
                        c.setName(rs.getString("name"));
                        c.setUserName(rs.getString("userName"));
                        c.setPassword(rs.getString("password"));
                        c.setDatefBirth(rs.getDate("dateOfBirth"));
                        c.setAddress(rs.getString("address"));
                        c.setPhoneNumber(rs.getString("phoneNumber"));
                        c.setRole(rs.getString("role"));
                        c.setNote(rs.getString("note"));
                        c.setEmail(rs.getString("email"));
                        c.setPosition(rs.getString("position"));
                    }
                }
                b.setSales(c);
            }
            
            sql =   "select * from restman.tblordereddish where tblBillId = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, b.getId());
            System.out.println(b.getId());
            
            float total = 0;
            ArrayList<OrderedDish> c = new ArrayList<>();
            DishDAO dishDAO = new DishDAO();
                
            try (ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    OrderedDish o = new OrderedDish();
                    o.setDate(rs.getDate("date"));
                    o.setQuantity(rs.getInt("quantity"));
                    o.setId(rs.getInt("id"));
                    
                    o.setDish(dishDAO.getDishById(rs.getInt("tblDishId")));
                    
                    total += o.getQuantity() * o.getDish().getPrice();
                    
                    c.add(o);
                }
            }
            b.setListDish(c);
            b.setTotal(total);
                       
            ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        return b;
    }
}
