<%-- 
    Document   : index
    Created on : Oct 15, 2025, 3:49:33 PM
    Author     : viet5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng nhập Hệ thống</title>   
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f7f9;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
        button {
            background-color: #28a745;
            color: white;
            padding: 10px 18px;
            margin-top: 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
 <div class="login-container">
    <a href="${pageContext.request.contextPath}/View/Manager/StatisticsSelectionView.jsp">
        <button>Khách hàng</button>
    </a>
    <a href="${pageContext.request.contextPath}/View/Manager/StatisticsSelectionView.jsp">
        <button>Quản lý</button>
    </a>
 </div>
</body>
</html>