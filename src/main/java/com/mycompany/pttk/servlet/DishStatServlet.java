/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pttk.servlet;
import com.mycompany.pttk.DAO.DishStatDAO;
import com.mycompany.pttk.model.DishStat;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

/**
 *
 * @author viet5
 */

@WebServlet("/DishStatServlet")
public class DishStatServlet extends HttpServlet {
    private DishStatDAO dishStatDAO;

    @Override
    public void init() {
        dishStatDAO = new DishStatDAO();
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
                case "getRevenueStat":
                    getRevenueStat(request, response);
                    dispatcher = request.getRequestDispatcher("/View/Manager/DishRevenueStatisticsView.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
    
    private void getRevenueStat(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        
        System.out.println(startDateStr + " " + endDateStr);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date StartDate = null;
        Date EndDate = null;
        
        try {
            StartDate = formatter.parse(startDateStr); 
            EndDate = formatter.parse(endDateStr);

            ArrayList<DishStat> dishListStat = dishStatDAO.getDishRevenueStatisticsByDate(StartDate, EndDate);
            float totalRevenue = 0;
            for(int i =0; i < dishListStat.size(); i++){
                totalRevenue += dishListStat.get(i).getTotal();
            }
            
            request.setAttribute("totalRevenue", totalRevenue);
            request.setAttribute("listDishStat", dishListStat);


        } catch (ParseException e) {
            System.err.println("Lỗi định dạng ngày tháng: " + e.getMessage());
        }
        
    }
}
