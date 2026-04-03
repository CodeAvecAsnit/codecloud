
<%@ page import="jakarta.servlet.http.*,jakarta.servlet.*" %>
<%
    String user = (session != null) ? (String) session.getAttribute("username") : null;

    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head><title>Welcome</title></head>
<body>
<h2>Welcome, <%= user %>!</h2>
<a href="logout.jsp">Logout</a>
</body>
</html>
