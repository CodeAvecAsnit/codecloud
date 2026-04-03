<%@ page import="com.labwork.jspjava.jdbc.User" %>
<%@ page import="com.labwork.jspjava.jdbc.UserService" %>
<%@ page import="com.labwork.jspjava.jdbc.UserServiceImpl" %>
<%@ page import="com.labwork.jspjava.jdbc.UserRepositoryImpl" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    UserService userService = new UserServiceImpl(new UserRepositoryImpl());
    String method = request.getMethod();
    String action = request.getParameter("action");

    if ("POST".equalsIgnoreCase(method) && action != null) {
        try {
            if ("create".equals(action)) {
                User nextUser = new User();
                nextUser.setFirstName(request.getParameter("firstName"));
                nextUser.setLastname(request.getParameter("lastName"));
                nextUser.setBalance(Double.parseDouble(request.getParameter("balance")));
                userService.createUser(nextUser);
            } else if ("update".equals(action)) {
                User nextUser = new User();
                nextUser.setUserId(Integer.parseInt(request.getParameter("userId")));
                nextUser.setFirstName(request.getParameter("firstName"));
                nextUser.setLastname(request.getParameter("lastName"));
                nextUser.setBalance(Double.parseDouble(request.getParameter("balance")));
                userService.updateUser(nextUser);
            } else if ("delete".equals(action)) {
                int userId = Integer.parseInt(request.getParameter("userId"));
                userService.deleteUser(userId);
            }
            response.sendRedirect("users.jsp");
            return;
        } catch (Exception ex) {
            out.println("<h2 style='color:red'>Error: " + ex.getMessage() + "</h2>");
        }
    }
    List<User> users = userService.getAllUsers();
%>

<html>
<head>
    <title>User Management</title>
    <style>
        body { font-family: Arial; padding: 20px; }
        table { border-collapse: collapse; width: 100%; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .btn-delete { color: red; cursor: pointer; }
    </style>
</head>
<body>

<h2>User Management (JSP Version)</h2>

<h3>Create New User</h3>
<form method="post" action="users.jsp">
    <input type="hidden" name="action" value="create">
    First Name: <input type="text" name="firstName" required>
    Last Name: <input type="text" name="lastName" required>
    Balance: <input type="number" step="0.01" name="balance" required>
    <button type="submit">Create</button>
</form>

<h3>Existing Users</h3>
<table>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Balance</th>
        <th>Actions</th>
    </tr>

    <% for (User user : users) { %>
    <tr>
        <form method="post" action="users.jsp" style="margin:0;">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="userId" value="<%= user.getUserId() %>">

            <td><%= user.getUserId() %></td>
            <td><input type="text" name="firstName" value="<%= user.getFirstName() %>" required></td>
            <td><input type="text" name="lastName" value="<%= user.getLastname() %>" required></td>
            <td><input type="number" step="0.01" name="balance" value="<%= user.getBalance() %>" required></td>

            <td>
                <button type="submit">Update</button>
        </form>

        <form method="post" action="users.jsp" style="display:inline;">
            <input type="hidden" name="action" value="delete">
            <input type="hidden" name="userId" value="<%= user.getUserId() %>">
            <button type="submit" class="btn-delete">Delete</button>
        </form>
        </td>
    </tr>
    <% } %>
</table>

</body>
</html>