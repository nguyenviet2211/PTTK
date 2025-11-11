<%-- 
    Document   : ManagerHomeView
    Created on : Oct 13, 2025, 8:23:41 PM
    Author     : viet5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ quản lý</title>
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f4f7f9;
                color: #333;
                text-align: center;
                padding-top: 50px;
            }
            h1 {
                color: #dc3545; /* Màu đỏ cho quản lý */
                margin-bottom: 40px;
            }
            button {
                background-color: #dc3545;
                color: white;
                padding: 15px 30px;
                border: none;
                border-radius: 8px;
                cursor: pointer;
                font-size: 18px;
                transition: background-color 0.3s, transform 0.1s;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            }
            button:hover {
                background-color: #c82333;
                transform: translateY(-2px);
            }
            #logout-btn {
                position:absolute;
                top:20px;
                right:20px;
                color: blue;
                background-color: #f4f7f9;
                padding: 10px 20px;
                font-size: 16px;
                box-shadow: none;
                text-decoration: underline;
            }
            #logout-btn:hover {
                color: red;
            }
        </style>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/index.jsp">
           <button id="logout-btn">Đăng Xuất</button>
        </a>
        </div>
        <h1>Trang chủ quản lý</h1>
        <a href="${pageContext.request.contextPath}/View/Manager/StatisticsSelectionView.jsp">
            <button>Xem báo cáo</button>
        </a>
    </body>
</html>
