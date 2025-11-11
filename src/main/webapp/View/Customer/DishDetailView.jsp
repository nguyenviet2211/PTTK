<%-- 
    Document   : DishDetailView
    Created on : Oct 12, 2025, 7:50:06 PM
    Author     : viet5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            max-width: 600px;
            margin: 40px auto;
            padding: 30px;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #007bff;
            margin-bottom: 30px;
            padding-bottom: 10px;
            border-bottom: 2px solid #007bff;
            text-align: center;
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
    <div class="container">
        <a href="${pageContext.request.contextPath}/index.jsp" class="btn" style="right:20px;">Đăng xuất</a>
        <button class="btn" style="left: 20px;border:none;" onclick="history.back()">Quay lại</button>
        <h2>Chi tiết món ăn</h2>
        <c:if test="${not empty dish}">
            <ul>
                <li><strong>Tên món ăn:</strong><span>${dish.name}</span> </li>
                <li><strong>Giá bán:</strong><span>${dish.price} VNĐ</span> </li>
                <li><strong>Nguyên liệu chính:</strong><span>${dish.ingredient}</span></li>
                <li><strong>Mô tả:</strong> <span>${dish.description}</span> </li>
            </ul>
        </c:if>
    </div>
</body>
</html>
