<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>

        <form method="POST" action="updateProduct">
            <input name="productId" type="hidden" value="${product.productId}"/>
            Product Name:
            <input name="productName" type="input" value="${product.productName}"/><br/>
            <input type="submit" value="SEND"/>
        </form>

    </body>
</html>