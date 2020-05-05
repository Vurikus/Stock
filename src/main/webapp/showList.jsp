<%@ page import="logic.Thing" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Name" %>
<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 26.04.2020
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>

<html>
<head>
    <title>Show list of things</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>Thing</td>
            <td>Quantity</td>
            <td>Date added</td>
        </tr>
        <c:forEach var="Thing" items="${list}">
            <tr>
                <td>${Thing.ID}</td>
                <td>${Thing.nameThing}</td>
                <td>${Thing.quantity}</td>
                <td>${Thing.addThingDate.toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))}</td>
            </tr>
        </c:forEach>

    </table>
    <br/>
    <button onclick="location.href='/stock/addThing'">Add new Thing</button>

</body>
</html>
