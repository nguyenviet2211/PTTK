<%-- 
    Document   : ManagerDishDetailView
    Created on : Oct 13, 2025, 8:32:55 PM
    Author     : viet5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết món ăn</title>
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
            h2 {
                color: #dc3545;
                margin-bottom: 30px;
                padding-bottom: 10px;
                border-bottom: 2px solid #dc3545;
                text-align: center;
            }
            h3 {
                color: #007bff;
                margin-top: 30px;
                margin-bottom: 15px;
                border-left: 5px solid #007bff;
                padding-left: 10px;
            }
            ul {
                list-style: none;
                padding: 0;
            }
            li {
                padding: 8px 0;
                border-bottom: 1px dashed #eee;
            }
            li strong {
                display: inline-block;
                width: 150px;
                font-weight: bold;
                color: #555;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin: 20px 0;
            }
            th, td {
                padding: 10px 15px;
                text-align: center;
                border-bottom: 1px solid #e0e0e0;
                border-right: 1px solid #e0e0e0;
            }
            th {
                background-color: #007bff;
                color: white;
                text-transform: uppercase;
                font-weight: 600;
            }
            
            td:last-child{
                border-right: none;
            }
            tr:nth-child(even) {
                background-color: #f7f7f7;
            }
            tr:hover {
                background-color: #e9f0f8;
            }
            td a {
                color: #28a745;
                text-decoration: none;
                font-weight: bold;
            }
            a:hover {
                text-decoration: underline;
            }
            ul {
                list-style: none;
                padding: 0;
            }
            li {
                display:flex;
                padding: 12px 0;
                border-bottom: 1px dashed #eee;
                font-size: 1.1em;
            }
            li:last-child {
                border-bottom: none;
            }
            li strong {
                flex-shrink: 0;
                display: inline-block;
                width: 200px;
                font-weight: bold;
                color: #555;
            }
            li span {
                flex-grow: 1; 
                white-space: pre-wrap;
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
        <a href="${pageContext.request.contextPath}/index.jsp" class="btn" style="right:20px;">Đăng xuất</a>
        <button style="left:20px;border:none" class="btn" onclick="history.back()">Quay lại</button>
        <div class="container">
            <h2>Chi tiết món ăn</h2>
            <c:if test="${not empty dish}">
                <ul>
                    <li><strong>Tên món ăn:</strong>${dish.name}</li>
                    <li><strong>Giá bán:</strong><fmt:formatNumber value="${dish.price}"/> VNĐ</li>
                    <li><strong>Nguyên liệu chính:</strong><span>${dish.ingredient}</spam></li>
                    <li><strong>Mô tả:</strong><span>${dish.description}</span></li>
                </ul>
            </c:if>
            
            <h3>Lịch sử bán món ${dish.name} từ ngày ${param.startDate} đến ngày ${param.endDate}</h3>
            
            <c:if test="${not empty orderHistory}">
                
                <c:set var="totalQuantity" value="${0}" />
                <c:set var="totalRevenue" value="${0}" />
                <table>
                    <thead>
                        <tr>
                            <th style="text-align:left">Thời gian</th>
                            <th>Số lượng</th>
                            <th style="text-align:right">Thành tiền(VNĐ)</th>
                            <th>Hóa đơn</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${orderHistory}">
                            <tr>
                                <c:set var="totalQuantity" value="${totalQuantity + order.quantity}" />
                                <c:set var="totalRevenue" value="${totalRevenue + order.quantity * dish.price}" />
                                <td  style="text-align:left">
                                    <fmt:formatDate value="${order.date}" pattern="dd/MM/yyyy"/>
                                </td>

                                <td>${order.quantity}</td>

                                <td  style="text-align:right">
                                    <fmt:formatNumber value="${order.quantity * dish.price}"/>
                                </td>

                                <td>
                                    <a href="${pageContext.request.contextPath}/BillServlet?action=detail&orderId=${order.id}">
                                        click xem hóa đơn
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                            
                        <tr class="total-row">
                            <td style="text-align: left;">Tổng cộng:</td>
                            <td>${totalQuantity}</td>
                            <td  style="text-align:right">
                                <fmt:formatNumber value="${totalRevenue}" type="currency" currencySymbol="VND"/>
                            </td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </c:if>
        </div>
    </body>
</html>