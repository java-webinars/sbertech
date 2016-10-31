<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Page</title>
    </head>
    <body>
        <h1>Test data</h1>

        <h1>
        <%
          String r = (String)request.getAttribute("MODEL");
          out.print(r);
        %>
        </h1>

        <h1><%=request.getAttribute("MODEL")%> </h1>

        <h1>${MODEL}</h1>
        <h1>${SESSION}</h1>

        <a href="index.html">INDEX TEST</a>

    </body>
</html>