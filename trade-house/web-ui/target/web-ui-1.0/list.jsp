<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>

        <table border="1">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${products}" var="product" varStatus="status">
                     <tr>
                        <td>>${status.count}</td>
                        <td>${product.productId}</td>
                        <td>${product.productName}</td>
                        <td>Del</td>
                     </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
