<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Edit</title>

</head>
<body>

<h2>Edit Framework</h2>

<table border="1">
    <th>ID</th>
    <th>Name</th>
    <th>Edit Name</th>
    <th>Description</th>
    <th>Edit Description</th>
    <th>Website Link</th>
    <th>Edit Website Link</th>

    <c:forEach var="framework" items="${frameworkList}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${framework.name}</td>
            <td><input id="editName" placeholder="Edit name"></td>
            <td>${framework.description}</td>
            <td><input id="editDescription" placeholder="Edit description"></td>
            <td>${framework.websiteLink}</td>
            <td><input id="editWebsiteLink" placeholder="Edit website link"></td>

           <td> <input type="submit" id="editFrameworkButton" value="Register changes"></td>
           <td><input type="submit" id="deleteFramework" value="Delete Framework"></td>

        </tr>
    </c:forEach>

</table>



<h2>Edit User</h2>

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

                <form:form action="edit/update" method="post">
                    <input type="hidden" value="${user}">

                    <td><input type="submit" id="editUserButton" value="Register changes"></td>
                </form:form>

                <form:form action="edit/delete" method="post" modelAttribute="User">

                    <td><form:hidden path="id" value="${user.id}"/>

                    <input type="submit" id="deleteUser" value="Delete User"></td>
                </form:form>
            </tr>
        </c:forEach>


</table>






</body>
</html>
