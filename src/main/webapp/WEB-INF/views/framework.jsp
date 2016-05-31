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

<h1>Framework List</h1>
<table border="1">
    <th>ID</th>
    <th>Edit Name</th>
    <th>Edit Description</th>
    <th>Edit Website Link</th>

    <c:forEach var="framework" items="${frameworkList}" varStatus="status">
        <tr>
            <form:form action="/update/framework" method="post">
            <td>${status.index + 1}</td>

            <td><input name="name" placeholder="${framework.name}" value="${framework.name}"></td>
            <td><input name="description" placeholder="${framework.description}" value="${framework.description}"></td>
            <td><input name="websiteLink" placeholder="${framework.websiteLink}" value="${framework.websiteLink}"></td>

            <input type="hidden" name="id" value=${framework.id}>


                <td><input type="submit" value="Register changes"></td>
            </form:form>

            <form:form action="/delete/framework" method="post" modelAttribute="framework">

                <td><form:hidden path="id" value="${framework.id}"/>

                    <input type="submit" value="Delete Framework"></td>
            </form:form>

            <form:form action="/review/framework" method="post" modelAttribute="framework">

                <td>
                    <input type="hidden" name="id" value=${framework.id}>

                    <input type="submit" value="Review Framework"></td>
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
