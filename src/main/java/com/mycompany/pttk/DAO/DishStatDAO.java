/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pttk.DAO;

/**
 *
 * @author viet5
 */
import java.util.*;
import com.mycompany.pttk.model.DishStat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DishStatDAO extends DAO {
    
    public DishStatDAO(){}
    
    public ArrayList<DishStat> getDishRevenueStatisticsByDate(Date startDate, Date endDate){
        ArrayList<DishStat> listStat = new ArrayList<>();
                
        String sql = "SELECT\n" +
                    "    t1.id AS id,\n" +
                    "    t1.name AS name,\n" +
                    "    t1.price AS price,\n" +
                    "    t1.description AS description,\n" +
                    "    t1.ingredient AS ingredient,\n" +
                    "    t1.status AS status,\n" +
                    "    t1.imgPath AS imgPath,\n" +
                    "    SUM(t1.price * t2.quantity) AS total\n" +
                    "FROM\n" +
                    "    restman.tbldish AS t1\n" +
                    "JOIN\n" +
                    "    restman.tblordereddish AS t2 ON t1.id = t2.tblDishId\n" +
                    "WHERE\n" +
                    "    t2.date BETWEEN ? AND ?\n" +
                    "GROUP BY\n" +
                    "    t1.id\n" +
                    "ORDER BY\n" +
                    "    total DESC;";
        
        try(Connection con = getConnection();PreparedStatement ps = con.prepareStatement(sql);) {
            
            ps.setDate(1, new java.sql.Date(startDate.getTime()));
            ps.setDate(2, new java.sql.Date(endDate.getTime())); 
            
            try (ResultSet rs = ps.executeQuery();){
                while(rs.next()){
                    DishStat dish = new DishStat();
                    
                    dish.setId(rs.getInt("id"));
                    dish.setName(rs.getString("name"));
                    dish.setPrice(rs.getFloat("price"));
                    dish.setDescription(rs.getString("description"));
                    dish.setIngredient(rs.getString("ingredient"));
                    dish.setStatus(rs.getInt("status"));
                    dish.setImgPath(rs.getString("imgPath"));
                    dish.setTotal(rs.getFloat("total"));
                                        
                    listStat.add(dish);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return listStat;
    } 
}
