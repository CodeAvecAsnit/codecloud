

<%@ page import="jakarta.servlet.http.*,jakarta.servlet.*" %>
<%
    if (session != null) {
        session.invalidate();
    }
    response.sendRedirect("login.jsp");
%>
