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


    <form:form action="user" method="post">
        <input name="name" placeholder="name">
        <input name="email" placeholder="E-mail">
        Enter Password :<input type="password" name="password"/><br/>
        <input type="submit" value="Register new user">
    </form:form>


</body>
</html>
