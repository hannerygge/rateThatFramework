<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>LogIn</title>
</head>
<body>


<form id="logInForm">
    <h2>Username: </h2> <input id="logInUserName" type="text" name="uname"/>
    <h2>Password: </h2> <input id="logInPassword" type="text" name="pword"/>

    <button type="submit" id="logIn" name="login">Register</button>
</form>

</body>
</html>
