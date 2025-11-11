/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pttk.DAO;

import com.mycompany.pttk.model.OrderedDish;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author viet5
 */
public class OrderedDishDAO extends DAO{

    public OrderedDishDAO() {
        super();
    }
    
    public ArrayList<OrderedDish> getDishOrderHistoryByDateAndId(Date startDate, Date endDate, int id){
        System.out.println("calling");
        ArrayList<OrderedDish> resp = null;
        
        String sql = "select id, quantity, date \n" +
                        "from restman.tblordereddish\n" +
                        "where tblDishId = ? and date between ? and ?;\n";
        Connection con = this.con;
        try( PreparedStatement ps = con.prepareStatement(sql);) {
            System.out.println("calling");
            resp = new ArrayList<>();
            ps.setInt(1, id);
            ps.setDate(2, new java.sql.Date(startDate.getTime()));
            ps.setDate(3, new java.sql.Date(endDate.getTime())); 
            
            
            try (ResultSet rs = ps.executeQuery();){
                while(rs.next()){
                    System.out.println("1");
                    OrderedDish d = new OrderedDish();
                    
                    d.setId(rs.getInt("id"));
                    d.setQuantity(rs.getInt("quantity"));
                    d.setDate(rs.getDate("date"));
                    
                    resp.add(d);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return resp;
    }
}
