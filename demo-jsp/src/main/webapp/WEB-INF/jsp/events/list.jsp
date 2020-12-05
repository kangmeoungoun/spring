<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-12-05
  Time: 오전 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>이벤트 목록</h1>
    <h2>${requestScope.message}</h2>
    <table>
        <tr>
            <th>이름</th>
            <th>시작</th>
        </tr>
        <c:forEach var="event" items="${requestScope.events}">
            <tr>
                <td>${event.name}</td>
                <td>${event.starts}</td>
            </tr>

        </c:forEach>
    </table>
</body>
</html>
