<%-- 
    Document   : CustomerHomeView
    Created on : Oct 12, 2025, 7:29:06 PM
    Author     : viet5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ khách hàng</title>
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f4f7f9;
                color: #333;
                text-align: center;
                padding-top: 50px;
            }
            h1 {
                color: #007bff;
                margin-bottom: 40px;
            }
            .s-btn {
                background-color: #28a745;
                color: white;
                padding: 15px 30px;
                border: none;
                border-radius: 8px;
                cursor: pointer;
                font-size: 18px;
                transition: background-color 0.3s, transform 0.1s;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            }
            .s-btn:hover {
                background-color: #218838;
                transform: translateY(-2px);
            }
            div {
                margin: 20px;
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
                border :none;
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
        <h1>Trang chủ khách hàng</h1>
        <div>
            <a href="${pageContext.request.contextPath}/View/Customer/SearchView.jsp">
                <button class="s-btn">Tìm kiếm món ăn</button>
            </a>
        </div>
            
    </body>
</html>
