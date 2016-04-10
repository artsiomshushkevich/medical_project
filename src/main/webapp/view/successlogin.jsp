<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 09.04.16
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Welcome <%=session.getAttribute("name")%>!
<%if (session.getAttribute("role").equals("Admin"))
response.sendRedirect("adminpanel.action");%>
</body>
</html>
