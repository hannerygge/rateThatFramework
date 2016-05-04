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

<h1>Framework List</h1>
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


            <form:form action="/update/framework" method="post">
                <input type="hidden" value="${framework}">

                <td><input type="submit" value="Register changes"></td>
            </form:form>

            <form:form action="/delete/framework" method="post" modelAttribute="framework">

                <td><form:hidden path="id" value="${framework.id}"/>

                    <input type="submit" value="Delete Framework"></td>
            </form:form>

        </tr>
    </c:forEach>

</table>


</body>
</html>
