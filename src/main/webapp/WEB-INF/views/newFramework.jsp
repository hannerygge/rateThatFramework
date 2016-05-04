<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Register a new framework</title>
</head>
<body>


    <form:form action="framework" method="post">
        <input name="name" placeholder="Name">
        <input name="description" placeholder="Description">
        <input name="websiteLink" placeholder="Website Link">
        <input type="submit" value="Register new framework">
    </form:form>

    <form:form action="/home" method="get">
        <input type="submit" id="goToHomeButton" value="Home">
    </form:form>

</body>
</html>
