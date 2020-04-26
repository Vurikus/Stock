<%@ page import="java.util.ArrayList" %>
<%@ page import="logic.Thing" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Stock Application</title>
</head>
<body>
    <h1> Add new Thing and his quantity</h1>

    <form method="post">
        <label>Name thing:
            <input type="text" name="name"><br />
        </label>
        <label>Quantity:
            <input type="text" name="quantity"><br />
        </label>
        <button type="submit">Save thing</button>
    </form>
</body>
</html>
