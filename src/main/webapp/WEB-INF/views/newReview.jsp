<%@ page import="com.rateThatFramework.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Register new review</title>
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
${sessionScope.user} and ${framework}
    <form:form action="review" method="post" id="review">
        <!--input type="hidden" name="user" value="${sessionScope.user}"-->
        <!--input type="hidden" name="framework" value="${framework}"-->
        <td>
            <form:hidden path="user" value="${sessionScope.user}"/>
        </td>
        <td>
            <form:hidden path="framework" value="${framework}"/>
        </td>

        <input name="review" placeholder="Review">
        <input type="submit" value="Register review">
    </form:form>

<% } %>
</body>
</html>