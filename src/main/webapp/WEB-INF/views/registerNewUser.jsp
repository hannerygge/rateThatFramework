<%@ page import="com.rateThatFramework.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Register new user</title>
</head>
<body>
<%  HttpSession session1 = request.getSession();
    User test = (User)session1.getAttribute("user");
    if(test == null){
%>
<c:redirect url="login"/>
<%
}
else { %>

    <form:form action="user" method="post">
        <input name="name" placeholder="name">
        <input name="email" placeholder="E-mail">
        Enter Password :<input type="password" name="password"/><br/>
        <input type="submit" value="Register new user">
    </form:form>

    <form:form action="/home" method="get">
        <input type="submit" id="goToHomeButton" value="Home">
    </form:form>

<% } %>
</body>
</html>
