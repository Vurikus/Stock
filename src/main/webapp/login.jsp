<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>

<html>
<head>
    <title>log in</title>
</head>
<body>
    <form method="post">
        <label>Login:
            <input type="text" name="login" ><br />
            <p><%
                String error = request.getParameter("error");
                if(error != null) {
                    out.println(error);
                }
            %></p>
        </label>
        <label>Password:
            <input type="password" name="password" ><br />
        </label>

        <button type="submit">Login</button>

    </form>

</body>
</html>