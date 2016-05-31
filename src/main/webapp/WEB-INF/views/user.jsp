<%@ page import="com.rateThatFramework.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Framework</title>
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

<table border="1">
    <th>ID</th>
    <th>Edit Username</th>
    <th>Edit E-mail</th>
    <th>Edit Admin Access</th>


    <c:forEach var="user" items="${userList}" varStatus="status">
        <tr>

            <form:form action="/user/update" method="post" modelAttribute="user">
                <td>${status.index + 1}</td>
                <td><input type= "text" name="name" placeholder="${user.name}" value="${user.name}"></td>

                <td><input type= "text" name="email" placeholder="${user.email}" value="${user.email}"></td>
                <td><input name="admin" placeholder="${user.admin}" value="${user.admin}"></td>

                <input type="hidden" name="id" value=${user.id}>
                <input type="hidden" name="password" value="${user.password}">

            <td><input type="submit" value="Register changes"></td>
        </form:form>

            <form:form action="/delete/user" method="post" modelAttribute="user">

                <td><form:hidden path="id" value="${user.id}"/>

                    <input type="submit" value="Delete User"></td>
            </form:form>
        </tr>
    </c:forEach>
</table>

<form:form action="/home" method="get">
    <input type="submit" id="goToHomeButton" value="Home">
</form:form>

<% } %>
</body>
</html>
