/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pttk.servlet;

import com.mycompany.pttk.DAO.BillDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viet5
 */
@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
    private BillDAO billDAO;

    @Override
    public void init() {
        billDAO = new BillDAO();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("action");
        RequestDispatcher dispatcher;
        if (action == null) {
            return;
        }

        try {
            switch (action) {
                case "detail":
                    getBill(request, response);
                    dispatcher = request.getRequestDispatcher("/View/Manager/BillView.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
    
    private void getBill(HttpServletRequest request, HttpServletResponse response){
        int orderedDishId = Integer.parseInt(request.getParameter("orderId"));    
        request.setAttribute("bill", billDAO.getBillById(orderedDishId));
    }
}
