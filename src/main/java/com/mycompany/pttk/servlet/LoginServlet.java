/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pttk.servlet;


import java.io.IOException;
import com.mycompany.pttk.DAO.LoginDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginDAO loginDao;

    public void init() {
        loginDao = new LoginDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            String role = loginDao.validate(username, password);
            if (role.equals("staff")) {
                response.sendRedirect("/PTTK/View/Manager/ManagerHomeView.jsp");
            } else if (role.equals("customer")){
                response.sendRedirect("/PTTK/View/Customer/CustomerHomeView.jsp");
            } else {
                request.setAttribute("message", "Sai mật khẩu rồi");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
