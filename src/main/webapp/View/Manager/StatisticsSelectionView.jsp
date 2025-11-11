<%-- 
    Document   : StatisticsSelectionView
    Created on : Oct 13, 2025, 8:25:53 PM
    Author     : viet5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Báo cáo</title>
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f4f7f9;
                color: #333;
                padding: 20px;
            }
            .container {
                max-width: 600px;
                margin: 40px auto;
                padding: 30px;
                background: #fff;
                border-radius: 10px;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
                position: relative;
            }
            h1 {
                color: #dc3545;
                text-align: center;
                margin-bottom: 30px;
                border-bottom: 2px solid #dc3545;
                padding-bottom: 10px;
            }
            
            .btn1 {
                background-color: #007bff;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
                transition: background-color 0.3s, transform 0.1s;
                text-align: center;
                display: block;
                box-sizing: border-box;
                text-decoration: none;
                width: 100%;
                margin-bottom: 15px;
            }
            .btn1:hover {
                background-color: #0056b3;
                transform: translateY(-1px);
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
            <a href="${pageContext.request.contextPath}/View/Manager/ManagerHomeView.jsp" class="btn" style="left:20px;" >Quay lại</a>
            <a href="${pageContext.request.contextPath}/index.jsp" class="btn" style="right:20px;">Đăng xuất</a>
        <div class="container">
            
            <h1>Báo cáo</h1>
                <a class="btn1" href="${pageContext.request.contextPath}/View/Manager/DishRevenueStatisticsView.jsp">
                    Thống kê món ăn theo doanh thu
                </a>
            <button class="btn1">Thống kê nguyên liệu</button>
            <button class="btn1">Thống kê khách hàng</button>
            <button class="btn1">Thống kê nhà cung cấp</button>
        </div>
    </body>
</html>
