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
    <th>Description</th>
    <th>Website Link</th>

    <c:forEach var="framework" items="${frameworkList}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${framework.name}</td>
            <td>${framework.description}</td>
            <td>${framework.websiteLink}</td>

            <input type="submit" id="reviewButton" value="Review">
            <input type="submit" id="rateButton" value="Rate">


        </tr>
    </c:forEach>
</table>


</body>
</html>
