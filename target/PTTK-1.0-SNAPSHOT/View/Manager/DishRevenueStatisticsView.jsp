<%-- 
    Document   : DishRevenueStatisticsView
    Created on : Oct 13, 2025, 8:28:23 PM
    Author     : viet5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thống kê món ăn theo doanh thu</title>
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f4f7f9;
                color: #333;
                padding: 20px;
            }
            .container {
                max-width: 1000px;
                margin: 40px auto;
                padding: 30px;
                background: #fff;
                border-radius: 10px;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            }
            h1 {
                color: #dc3545;
                text-align: center;
                margin-bottom: 30px;
                border-bottom: 2px solid #dc3545;
                padding-bottom: 10px;
            }
            form {
                background-color: #f9f9f9;
                padding: 20px;
                border-radius: 8px;
                margin-bottom: 25px;
                display: flex;
                gap: 15px;
                align-items: center;
                justify-content: center;
            }
            input[type="date"] {
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }
            button[type="submit"] {
                background-color: #007bff;
                color: white;
                padding: 8px 15px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s;
            }
            button[type="submit"]:hover {
                background-color: #0056b3;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin: 20px 0;
                border: 1px;
            }
            th, td {
                padding: 12px 15px;
                text-align: left;
                border-bottom: 1px solid #e0e0e0;
                border-right:  1px solid #e0e0e0;
            }
            
            td:last-child{
                border-right: none;
            }
            th {
                background-color: #dc3545;
                color: white;
                text-transform: capitalize;
                font-weight: 600;
            }
            tr:nth-child(even) {
                background-color: #f7f7f7;
            }
            tr:hover {
                background-color: #fbe6e8;
            }
            .total-row {
                font-size: 1.3em;
                font-weight: bold;
                text-align: right;
                margin-top: 25px;
                border-top: 3px double #dc3545;
                padding-top: 15px;
                color: #dc3545;
            }
            .no-revenue {
                color: #dc3545;
                text-align: center;
                font-weight: bold;
                margin-top: 30px;
                padding: 15px;
            }
            a {
                color: #007bff;
                text-decoration: none;
                font-weight: bold;
            }
            a:hover {
                text-decoration: underline;
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
        
            <a href="${pageContext.request.contextPath}/View/Manager/StatisticsSelectionView.jsp"  class="btn" style="left:20px; font-weight: normal" >Quay lại</a>
            <a href="${pageContext.request.contextPath}/index.jsp" class="btn" style="right:20px; font-weight: normal">Đăng xuất</a>
        
        <div class="container">
            <h1>Thống kê món ăn theo doanh thu</h1>
            
            <form action="${pageContext.request.contextPath}/DishStatServlet" method="GET">
                <input type="hidden" name="action" value="getRevenueStat">
                <label for="startDate">Ngày bắt đầu:</label>
                <input type="date" id="startDate" name="startDate" value="${param.startDate}" required> 

                <label for="endDate">Ngày kết thúc:</label>
                <input type="date" id="endDate" name="endDate" value="${param.endDate}" required>

                <button type="submit">Thống kê</button>
            </form>

            <hr style="border-top: 1px solid #ccc;">

            <c:if test="${not empty listDishStat}">

                <h3>Thống kê doanh thu từ ngày ${param.startDate} đến ${param.endDate}</h3>

                <table>
                    <thead>
                        <tr>
                            <th>Tên món ăn</th>
                            <th style="text-align:right">Giá bán(VNĐ)</th>
                            <th style="text-align:right">Doanh thu(VNĐ)</th>
                            <th style="text-align:center">Chi tiết</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="stat" items="${listDishStat}">
                            <tr>
                                <td>${stat.name}</td>
                                <td style="text-align:right">
                                    <fmt:formatNumber value="${stat.price}"/>
                                </td>
                                <td style="text-align:right">
                                    <fmt:formatNumber value="${stat.total}"/>
                                </td>
                                <td style="text-align:center">
                                    <a href="${pageContext.request.contextPath}/DishServlet?action=managerDetail&id=${stat.id}&startDate=${param.startDate}&endDate=${param.endDate}">
                                        xem chi tiết
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <p class="total-row">
                    Tổng doanh thu : <fmt:formatNumber value="${totalRevenue}" type="currency" currencySymbol="VND"/>
                </p>
            </c:if>

            <c:if test="${empty listDishStat and param.startDate != null and param.endDate != null}">
                <p class="no-revenue">Không có doanh thu trong khoảng từ ${param.startDate} đến ${param.endDate}.</p>
            </c:if>
        </div>
    </body>
</html>
