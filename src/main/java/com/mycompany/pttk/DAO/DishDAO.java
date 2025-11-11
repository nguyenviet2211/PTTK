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
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author viet5
 */
public class DishDAO extends DAO {
    public DishDAO() {
    }
    
    public Dish getDishById(int id){
        Dish dish = new Dish();
        String sql = "SELECT * FROM restman.tbldish WHERE id = ? LIMIT 1;";
        
        try (Connection con = getConnection();PreparedStatement ps = con.prepareStatement(sql);) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery();){
                while(rs.next()){
                    dish.setId(rs.getInt("id"));
                    dish.setName(rs.getString("name"));
                    dish.setPrice(rs.getFloat("price"));
                    dish.setDescription(rs.getString("description"));
                    dish.setIngredient(rs.getString("ingredient"));
                    dish.setStatus(rs.getInt("status"));
                    dish.setImgPath(rs.getString("imgPath"));   
                }
            } 
            
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    
       return dish;
    }
    
    public ArrayList<Dish> getListDishByName(String keyword){        
        ArrayList<Dish> searchResult = new ArrayList<>();
        
        String sql = "SELECT * FROM restman.tbldish WHERE name LIKE ?";
        
        try (Connection con = getConnection();PreparedStatement ps = con.prepareStatement(sql);) {
            
            ps.setString(1, "%" + keyword + "%");
            
            try (ResultSet rs = ps.executeQuery();){
                while(rs.next()){
                    Dish dish = new Dish();
                    
                    dish.setId(rs.getInt("id"));
                    dish.setName(rs.getString("name"));
                    dish.setPrice(rs.getFloat("price"));
                    dish.setDescription(rs.getString("description"));
                    dish.setIngredient(rs.getString("ingredient"));
                    dish.setStatus(rs.getInt("status"));
                    dish.setImgPath(rs.getString("imgPath"));  
                    
                    searchResult.add(dish);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return searchResult;
    }
    

}
