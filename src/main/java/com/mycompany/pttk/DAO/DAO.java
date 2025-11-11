/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pttk.DAO;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;
/**
 *
 * @author viet5
 */
public class DAO {
    protected Connection con;
    
    public DAO() { 
        String driver = "com.mysql.cj.jdbc.Driver"; 
            String url = "jdbc:mysql://localhost:3307/restman"; 
            String user = "root"; 
            String password = "Viet123456"; 

            try {
                Class.forName(driver);

                con = DriverManager.getConnection(url, user, password);
                System.out.println("Database connect Success!");
            } catch (ClassNotFoundException e) {
                System.err.println("Driver JDBC not found: " + driver);
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Error!");
                e.printStackTrace();
            }
        
    }
}
