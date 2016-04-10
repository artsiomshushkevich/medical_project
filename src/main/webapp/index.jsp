<%--
  Created by IntelliJ IDEA.
  User: vitalyorlov
  Date: 19.03.16
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Home</title>
    <link rel='stylesheet' href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css">
    <s:head />
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <ul class="nav navbar-nav navbar-right">
            <li><a class="btn btn-link" href="registration.action">Sing up</a></li>
            <c:set var="salary" scope="session" value='<%=session.getAttribute("role")%>'/>
            <c:if test="${salary eq null}">
                <li><a class="btn btn-link" href="authorisation.action">Sing in</a></li>
            </c:if>
            <c:set var="salary" scope="session" value='<%=session.getAttribute("role")%>'/>
            <c:if test="${salary eq not null}">
                <li><a class="btn btn-link" href="logout.action">Sing out</a></li>
            </c:if>
        </ul>
    </div>
</nav>


</body>
</html>
