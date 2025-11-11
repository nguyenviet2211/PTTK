<%-- 
    Document   : SearchView
    Created on : Oct 12, 2025, 7:49:51 PM
    Author     : viet5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tìm kiếm món ăn</title>
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f4f7f9;
                color: #333;
                padding: 20px;
            }
            .container {
                max-width: 900px;
                margin: 40px auto;
                padding: 30px;
                background: #fff;
                border-radius: 10px;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            }
            h2, h3 {
                color: #007bff;
                margin-bottom: 20px;
                padding-bottom: 5px;
                border-bottom: 1px solid #eee;
            }
            form {
                display:flex;
                align-items: center;
                padding: 20px;
                border: 1px solid #e0e0e0;
                border-radius: 8px;
                margin-bottom: 30px;
                background-color: #f9f9f9;
            }
            input[type="text"] {
                display:inline-block;
                flex-grow: 1;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                margin-right: 15px;
            }
            button[type="submit"] {
                background-color: #28a745;
                color: white;
                padding: 10px 18px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
                transition: background-color 0.3s;
                flex-shrink: 0;
            }
            button[type="submit"]:hover {
                background-color: #218838;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin: 20px 0;
            }
            th, td {
                padding: 12px 15px;
                text-align: center;
                border-bottom: 1px solid #e0e0e0;
                border-right: 1px solid #e0e0e0;
            }
            th {
                background-color: #dc3545;
                color: white;
                text-transform: capitalize;
                font-weight: 600;
            }
            td:last-child{
                border-right: none;
            }
            td a {
                color: #007bff;
                text-decoration: none;
                font-weight: bold;
            }
            td a:hover {
                text-decoration: underline;
            }
            tr:nth-child(even) {
                background-color: #f7f7f7;
            }
            tr:hover {
                background-color: #fbe6e8;
            }
            
            .btn {
                position:absolute;
                top:20px;
                color: blue;
                background-color: #f4f7f9;
                padding: 10px 20px;
                font-size: 16px;
                box-shadow: none;
                text-decoration: underline;
            }
            .btn:hover {
                color: red;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <a href="${pageContext.request.contextPath}/View/Customer/CustomerHomeView.jsp" class="btn" style="left : 20px;">Quay lại</a>
            <a href="${pageContext.request.contextPath}/index.jsp" class="btn" style="right:20px">Đăng Xuất</a>
            
            
            <h2 style="text-align:center">Tìm kiếm Món ăn</h2>
            <form action="${pageContext.request.contextPath}/DishServlet" method="GET">
                <input type="hidden" name="action" value="search">
                Từ khóa: &nbsp;<input type="text" name="keyword" value ="${param.keyword}" required>
                <button type="submit">Tìm kiếm</button>
            </form>

            <c:if test="${not empty listDish}">
                <h3>Kết quả tìm kiếm cho ${param.keyword}</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Tên Món</th>
                            <th style="width:150px">Giá (VNĐ)</th>
                            <th style="width:200px">Xem chi tiết</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dish" items="${listDish}">
                            <tr>
                                <td>${dish.name}</td>
                                <td style="text-align:right"><fmt:formatNumber value="${dish.price}" type="number" groupingUsed="true" maxFractionDigits="3"/></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/DishServlet?action=detail&id=${dish.id}">Xem chi tiết</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
                
            <c:if test="${empty listDish and param.keyword != null}">
                <h3>Không tìm thấy kết quả cho ${param.keyword}</h3>
            </c:if>
            
            <hr style="border-top: 1px solid #ccc; margin-top: 30px;">
        </div>
    </body>
</html>
