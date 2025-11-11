<%-- 
    Document   : BillView
    Created on : Oct 13, 2025, 8:33:14 PM
    Author     : viet5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chi tiết Hóa đơn - ${bill.billId}</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f7f9;
            color: #333;
            padding: 20px;
        }
        .bill-container {
            max-width: 650px; /* Tăng chiều rộng để căn cột dễ hơn */
            margin: 40px auto;
            padding: 30px;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #28a745;
            text-align: center;
            margin-bottom: 30px;
            padding-bottom: 10px;
            border-bottom: 3px double #28a745;
        }
        .info-row {
            margin-bottom: 10px;
            font-size: 1.1em;
        }
        .info-row strong {
            display: inline-block;
            width: 300px;
            font-weight: bold;
        }
        
        /* CSS cho phần chi tiết món ăn */
        .bill-items-header {
            font-weight: bold;
            margin-top: 20px;
            margin-bottom: 5px;
        }
        
        .item-row {
            display: grid;
            /* Chia thành 4 cột: STT + Tên | SL | Giá | Tổng tiền */
            grid-template-columns: 5fr 1fr 2fr 2.5fr; 
            padding: 8px 0;
            border-bottom: 1px dashed #eee;
            font-size: 1em;
            align-items: center;
        }
        .item-row span:nth-child(2) { /* Cột SL */
            text-align: center;
        }
        .item-row span:nth-child(3), /* Cột Giá */
        .item-row span:nth-child(4) { /* Cột Tổng */
            text-align: right;
            padding-left: 10px;
        }

        .total-row {
            margin-top: 20px;
            padding-top: 15px;
            border-top: 2px solid #333;
            font-size: 1.2em;
            font-weight: bold;
            color: #dc3545;
            display: flex;
            justify-content: space-between;
        }
        .total-row strong {
             width: auto;
        }
        .error-message {
            color: #dc3545;
            text-align: center;
            font-weight: bold;
            margin-top: 30px;
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
        <button style="left:20px;border:none" class="btn" onclick="history.back()">Quay lại</button>
        <a href="${pageContext.request.contextPath}/index.jsp" class="btn" style="right:20px;">Đăng xuất</a>
    
    <div class="bill-container">
        <c:if test="${not empty bill}">
            <h1>Hóa đơn</h1>

            <div class="info-row">
                <strong>Mã HĐ : </strong> ${bill.billId}
            </div>
            <div class="info-row">
                <strong>Thời gian : </strong> 
                <fmt:formatDate value="${bill.createdTime}" pattern="dd/MM/yyyy"/>
            </div>
            <div class="info-row">
                <strong>Khách hàng : </strong> ${bill.customer.name}
            </div>
            <div class="info-row">
                <strong>Nhân viên bán hàng : </strong> ${bill.sales.name}
            </div>
            
            <div class="bill-items-header">Chi tiết:</div>
            
            <div class="item-row" style="font-weight: bold; border-bottom: 2px solid #555; background-color: #f0f0f0;">
                <span>Tên Món</span>
                <span style="text-align: center;">SL</span>
                <span style="text-align: right;">Giá</span>
                <span style="text-align: right;">Tổng</span>
            </div>
            
            <c:set var="counter" value="${1}" />
            <c:if test="${not empty bill.listDish}"> 
                <c:forEach var="orderedDish" items="${bill.listDish}">
                    <div class="item-row">
                        <span>
                            ${counter}. ${orderedDish.dish.name}
                        </span>
                        
                        <span>
                            ${orderedDish.quantity}
                        </span>
                        
                        <span>
                            <fmt:formatNumber value="${orderedDish.dish.price}"/>
                        </span>

                        <c:set var="lineTotal" value="${orderedDish.quantity * orderedDish.dish.price}" />
                        <span>
                            <fmt:formatNumber value="${lineTotal}"/>
                        </span>
                    </div>
                    <c:set var="counter" value="${counter + 1}" />
                </c:forEach>
            </c:if>
            
            <c:if test="${not empty bill.listCombo}"> 
                 <c:forEach var="orderedCombo" items="${bill.listCombo}">
                    <div class="item-row">
                        <span>
                            ${counter}. ${orderedCombo.combo.name} (Combo)
                        </span>
                        
                        <span>
                            ${orderedCombo.quantity}
                        </span>
                        
                        <span>
                            <fmt:formatNumber value="${orderedCombo.combo.price}"/>
                        </span>
                        
                        <c:set var="lineTotalCombo" value="${orderedCombo.quantity * orderedCombo.combo.price}" />
                        <span>
                            <fmt:formatNumber value="${lineTotalCombo}"/>
                        </span>
                    </div>
                    <c:set var="counter" value="${counter + 1}" />
                </c:forEach>
            </c:if>
        
            <div class="total-row">
                <strong>Tổng tiền :</strong> 
                <span style="color: #dc3545;">
                    <fmt:formatNumber value="${bill.total}" type="currency" currencySymbol="VND" maxFractionDigits="0"/>
                </span>
            </div>
        </c:if>
    </div>
</body>
</html>