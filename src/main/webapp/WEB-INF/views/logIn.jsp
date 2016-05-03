<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>LogIn</title>
</head>
<body>
<h4>${param.message}</h4>
<form:form action="login" method="post">
    Enter User Name:<input type="text" name="username"> <br/>
    Enter Password :<input type="password" name="password"/><br/>
    <input type="submit" value="Log In">

</form:form>

<form:form action="registerNewUser" method="get">
    Register new user: <input type="submit" id="newUserButton" value="New User">

</form:form>

</body>
</html>
