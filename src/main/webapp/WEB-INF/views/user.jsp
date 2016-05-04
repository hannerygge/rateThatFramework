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
    <th>Username</th>
    <th>Edit Username</th>
    <th>E-mail</th>
    <th>Edit E-mail</th>
    <th>Admin Access</th>
    <th>Edit Admin Access</th>


    <c:forEach var="user" items="${userList}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${user.name}</td>
            <td><input id="editUsername" placeholder="Edit Username"></td>
            <td>${user.email}</td>
            <td><input id="editEmail" placeholder="Edit E-mail"></td>
            <td>${user.admin}</td>
            <td><input id="editAdminAccess" placeholder="Edit Admin Access"></td>

            <form:form action="edit/user/update" method="post">
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
