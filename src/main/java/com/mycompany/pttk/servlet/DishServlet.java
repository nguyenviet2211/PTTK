/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pttk.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.pttk.DAO.*;
import com.mycompany.pttk.model.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author viet5
 */
@WebServlet("/DishServlet")
public class DishServlet extends HttpServlet {
    private DishDAO dishDAO;
    private OrderedDishDAO orderedDishDAO;

    @Override
    public void init() {
        dishDAO = new DishDAO();
        orderedDishDAO = new OrderedDishDAO();
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
                    getDishById(request, response);
                    dispatcher = request.getRequestDispatcher("/View/Customer/DishDetailView.jsp");
                    dispatcher.forward(request, response);
                    break;
                case "search":
                    getListDishByName(request, response);  
                    dispatcher = request.getRequestDispatcher("/View/Customer/SearchView.jsp");
                    dispatcher.forward(request, response);
                    break;
                case "managerDetail":
                    getDishById(request, response);
                    getOrderHistory(request, response);
                    dispatcher = request.getRequestDispatcher("/View/Manager/ManagerDishDetailView.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
    
    private void getDishById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int dishId = Integer.parseInt(request.getParameter("id"));
        Dish dish = dishDAO.getDishById(dishId);
        
        request.setAttribute("dish", dish); 
        
    }
    
    private void getListDishByName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String keyword = request.getParameter("keyword");
        ArrayList<Dish> dishList = dishDAO.getListDishByName(keyword); 
        
        System.out.println("Keyword: " + keyword);
        request.setAttribute("listDish", dishList);
    }
    
    private void getOrderHistory(HttpServletRequest request, HttpServletResponse response){
        int dishId = Integer.parseInt(request.getParameter("id"));
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        
        System.out.println(startDateStr + " " + endDateStr);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date StartDate = null;
        Date EndDate = null;
        
        try {
            StartDate = formatter.parse(startDateStr); 
            EndDate = formatter.parse(endDateStr);
            ArrayList<OrderedDish> orderHistory = new ArrayList<>();
            orderHistory = orderedDishDAO.getDishOrderHistoryByDateAndId(StartDate, EndDate, dishId);
            request.setAttribute("orderHistory", orderHistory);
        } catch (ParseException e) {
            System.err.println("Lỗi định dạng ngày tháng: " + e.getMessage());
        }
        
    }
}
