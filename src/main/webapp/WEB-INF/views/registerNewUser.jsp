<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Register new user</title>
</head>
<body>

<form id="newUserForm">
   <h2>Username: </h2> <input id="userName" type="text" name="uname"/>
   <h2>E-mail: </h2> <input id="email" type="text" name="mail"/>
   <h2>Password: </h2> <input id="password" type="text" name="pword"/>

    <button type="submit" id="register" name="Register">Register</button>
</form>

</body>
</html>
