<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
</head>
<body>
<div align="center">
    <h1>User List</h1>
    <table border="1">
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>

        <c:forEach var="user" items="${userList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>

            </tr>
        </c:forEach>
    </table>

    <h1>Framework List</h1>
    <table border="1">
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Website Link</th>

        <c:forEach var="framework" items="${frameworkList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${framework.name}</td>
                <td>${framework.description}</td>
                <td>${framework.websiteLink}</td>

            </tr>
        </c:forEach>
    </table>

    <h1>Rating List</h1>
    <table border="1">
        <th>ID</th>
        <th>UserID</th>
        <th>FrameworkID</th>
        <th>Rating</th>

        <c:forEach var="rating" items="${ratingList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${rating.user.name}</td>
                <td>${rating.framework.name}</td>
                <td>${rating.rating}</td>

            </tr>
        </c:forEach>
    </table>

    <h1>Review List</h1>
    <table border="1">
        <th>ID</th>
        <th>UserID</th>
        <th>FrameworkID</th>
        <th>Review</th>

        <c:forEach var="review" items="${reviewList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${review.user.name}</td>
                <td>${review.framework.name}</td>
                <td>${review.review}</td>

            </tr>
        </c:forEach>
    </table>

    <br>

    <form:form action="user/edit" method="get">
        <input type="submit" id="goToEditButton" value="Edit">
    </form:form>
</div>
</body>
</html>