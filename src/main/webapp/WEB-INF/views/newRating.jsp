<%@ page import="com.rateThatFramework.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Register new rating</title>
</head>
<body>
<%  HttpSession session1 = request.getSession();
    User test = (User)session1.getAttribute("user");//(User)request.getSession().getAttribute("user");//(User)request.getAttribute("user");
    System.out.println(test);
    if(test == null){
%>
<c:redirect url="login"/>
<%
}
else { %>

<form:form action="createRating" method="post" id="createRating">

    <td><form:radiobuttons path="rating" items="${numberList}" />
    </td>
    <input type="submit" value="Register rating">
</form:form>

<% } %>
</body>
</html>