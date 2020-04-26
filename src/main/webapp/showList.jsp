<%@ page import="logic.Thing" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 26.04.2020
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show list of things</title>
</head>
<body>
    <% ArrayList<Thing> list = (ArrayList<Thing>) request.getAttribute("list");
        if (!list.isEmpty()){
            for (int i=0; i<list.size(); i++) {
                String s = list.get(i).getNameThing();
                int quantity = list.get(i).getQuantity();
                out.println("<p>" + s + " - " + quantity + "</p>");
            }
        }
        else out.println("<p> List is empty! Please, put anything </p>");
    %>
    <button onclick="location.href='/addThing'">Add new Thing</button>

</body>
</html>
