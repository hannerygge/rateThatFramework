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

<table border="1">
    <th>ID</th>
    <th>Edit Username</th>
    <th>Edit E-mail</th>
    <th>Edit Admin Access</th>


    <c:forEach var="user" items="${userList}" varStatus="status">
        <tr>

            <form:form action="/edit/user/update" method="post" modelAttribute="user">
            <td>${status.index + 1}</td>
            <td><input type= "text" name="name" placeholder=${user.name}></td>
            <td><input type= "text" name="email" placeholder=${user.email}></td>
            <td><input name="admin" placeholder=${user.admin}></td>


            <input type="hidden" value="${user}">

            <td><input type="submit" value="Register changes"></td>
        </form:form>

            <form:form action="/delete/user" method="post" modelAttribute="user">

                <td><form:hidden path="id" value="${user.id}"/>

                    <input type="submit" value="Delete User"></td>
            </form:form>
        </tr>
    </c:forEach>
</table>


</body>
</html>
