<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display and Scope Demo</title>
</head>
<body>
<%
    String name = request.getParameter("userName");
    String color = request.getParameter("favColor");
    pageContext.setAttribute("scopeMsg", "I am only on this page!", PageContext.PAGE_SCOPE);
    request.setAttribute("scopeMsg", "I travel with the request!");
    session.setAttribute("scopeMsg", "I remember you for this session!");
    application.setAttribute("scopeMsg", "I am global to the whole app!");
%>

<h2>Part A: Form Values Received</h2>
<p><strong>Name:</strong> <%= name %></p>
<p><strong>Favorite Color:</strong> <%= color %></p>

<hr>

<h2>Part B: Implicit Object Scopes</h2>
<table border="1">
    <tr>
        <th>Scope</th>
        <th>Value Stored</th>
    </tr>
    <tr>
        <td>Page Scope</td>
        <td>${pageScope.scopeMsg}</td>
    </tr>
    <tr>
        <td>Request Scope</td>
        <td>${requestScope.scopeMsg}</td>
    </tr>
    <tr>
        <td>Session Scope</td>
        <td>${sessionScope.scopeMsg}</td>
    </tr>
    <tr>
        <td>Application Scope</td>
        <td>${applicationScope.scopeMsg}</td>
    </tr>
</table>

<br>
<a href="input.jsp">Go back to form</a>
</body>
</html>