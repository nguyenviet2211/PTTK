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
import java.sql.*;

public class LoginDAO extends DAO{
    public LoginDAO(){
        
    }
    
    public String validate(String username, String password) throws Exception{
        String sql = "SELECT * FROM restman.tblmember WHERE username = ? AND password = ?";
        
        
        try (     Connection con = getConnection();PreparedStatement ps = con.prepareStatement(sql);){
            ps.setString(1, username);
            ps.setString(2, password);
            
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return rs.getString("role");
                } else {
                    return "";
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
