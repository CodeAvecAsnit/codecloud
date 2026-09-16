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
            response.sendRedirect("manager.jsp");
            return;
        } catch (Exception ex) {
            out.println("<div class='error-msg'>Error: " + ex.getMessage() + "</div>");
        }
    }
    List<User> users = userService.getAllUsers();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Manage Users</title>
</head>
<body>

<div class="container">
    <h2>Babin's Web App Manager</h2>

    <div class="card">
        <h3>CRUD Application</h3>
        <form method="post" action="manager.jsp" class="form-row">
            <input type="hidden" name="action" value="create">
            <div class="input-group">
                <label>Name</label>
                <input type="text" name="firstName" placeholder="John" required>
            </div>
            <div class="input-group">
                <label>Last Name</label>
                <input type="text" name="lastName" placeholder="Doe" required>
            </div>
            <div class="input-group">
                <label>Amount</label>
                <input type="number" step="0.01" name="balance" placeholder="0.00" required>
            </div>
            <button type="submit" class="btn-create">Create</button>
        </form>
    </div>

    <h3>Users</h3>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Last Name</th>
            <th>Balance</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
            <% for (User user : users) { %>
        <tr>
            <form method="post" action="manager.jsp">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="userId" value="<%= user.getUserId() %>">

                <td><strong>#<%= user.getUserId() %></strong></td>
                <td><input type="text" name="firstName" class="table-input" value="<%= user.getFirstName() %>" required></td>
                <td><input type="text" name="lastName" class="table-input" value="<%= user.getLastname() %>" required></td>
                <td><input type="number" step="0.01" name="balance" class="table-input" value="<%= user.getBalance() %>" required></td>

                <td>
                    <div style="display: flex;">
                        <button type="submit" class="btn-update">Update</button>
            </form>

            <form method="post" action="manager.jsp" onsubmit="return confirm('Delete this user?');">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="userId" value="<%= user.getUserId() %>">
                <button type="submit" class="btn-delete">Delete</button>
            </form>
</div>
</td>
</tr>
<% } %>
</tbody>
</table>
</div>
</body>
</html>