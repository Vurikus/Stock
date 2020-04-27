<%@ page import="logic.Thing" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Name" %>
<%--
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
    <table border="1">
        <tr>
            <td>ID</td>
            <td>Thing</td>
            <td>Quantity</td>
        </tr>

        <% ArrayList<Thing> list = (ArrayList<Thing>) request.getAttribute("list");
            if (!list.isEmpty()){
                for (int i=0; i<list.size(); i++) {
                    int id = list.get(i).getID();
                    String s = list.get(i).getNameThing();
                    int quantity = list.get(i).getQuantity();
                    out.println("<tr><td>" + id + " </td><td>  " + s + " </td><td>  " + quantity + "</td></tr>");
                }
            }
            else out.println("<p> List is empty! Please, put anything </p>");
        %>
    </table>
    <br/>
    <button onclick="location.href='/addThing'">Add new Thing</button>

</body>
</html>
