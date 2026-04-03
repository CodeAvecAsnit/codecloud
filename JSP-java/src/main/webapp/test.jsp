<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Date" %>

<html>
<head>
    <title>JSP Elements Demo</title>
</head>
<body>

<h2>JSP Elements Demonstration</h2>

<!-- JSP Declaration -->
<%!
    String message = "Welcome to JSP!";

    int square(int n) {
        return n * n;
    }
%>

<!-- JSP Expression -->
<p>Current Date and Time: <%= new Date() %></p>

<!-- JSP Expression using declared variable -->
<p>Message: <%= message %></p>

<!-- JSP Scriptlet -->
<%
    int num = 5;
    out.println("<p>Number: " + num + "</p>");
    out.println("<p>Square of " + num + " is: " + square(num) + "</p>");
%>

<!-- JSP Comment -->
<%-- This is a JSP comment. It will NOT be visible in the browser --%>

<!-- HTML Comment -->
<!-- This is an HTML comment. It WILL be visible in page source -->

</body>
</html>