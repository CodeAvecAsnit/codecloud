package com.labwork.jspjava;

import com.labwork.jspjava.jdbc.User;
import com.labwork.jspjava.jdbc.UserRepositoryImpl;
import com.labwork.jspjava.jdbc.UserService;
import com.labwork.jspjava.jdbc.UserServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = new UserServiceImpl(new UserRepositoryImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<User> users = userService.getAllUsers();

        out.println("<html><head><title>User Management</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; padding: 20px; }");
        out.println("table { border-collapse: collapse; width: 100%; margin-top: 20px; }");
        out.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println("form { margin: 0; }");
        out.println("</style></head><body>");

        out.println("<h2>User Management</h2>");

        out.println("<h3>Create New User</h3>");
        out.println("<form method='post' action='"+ request.getContextPath() +"/users'>");
        out.println("<input type='hidden' name='action' value='create'>");
        out.println("First Name: <input type='text' name='firstName' required> ");
        out.println("Last Name: <input type='text' name='lastName' required> ");
        out.println("Balance: <input type='number' step='0.01' name='balance' required> ");
        out.println("<button type='submit'>Create</button>");
        out.println("</form>");

        out.println("<h3>Existing Users</h3>");
        out.println("<table>");
        out.println("<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Balance</th><th>Actions</th></tr>");

        for (User user : users) {
            out.println("<tr>");

            out.println("<form method='post' action='" + request.getContextPath() + "/users'>");
            out.println("<input type='hidden' name='action' value='update'>");
            out.println("<input type='hidden' name='userId' value='" + user.getUserId() + "'>");
            
            out.println("<td>" + user.getUserId() + "</td>");
            out.println("<td><input type='text' name='firstName' value='" + user.getFirstName() + "' required></td>");
            out.println("<td><input type='text' name='lastName' value='" + user.getLastname() + "' required></td>");
            out.println("<td><input type='number' step='0.01' name='balance' value='" + user.getBalance() + "' required></td>");
            
            out.println("<td>");
            out.println("<button type='submit'>Update</button>");
            out.println("</form>");

            out.println("<form method='post' action='" + request.getContextPath() + "/users' style='display:inline;'>");
            out.println("<input type='hidden' name='action' value='delete'>");
            out.println("<input type='hidden' name='userId' value='" + user.getUserId() + "'>");
            out.println("<button type='submit' style='color:red;'>Delete</button>");
            out.println("</form>");
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect(request.getContextPath() + "/users");
            return;
        }

        try {
            switch (action) {
                case "create": {
                    User nextUser = new User();
                    nextUser.setFirstName(request.getParameter("firstName"));
                    nextUser.setLastname(request.getParameter("lastName"));
                    nextUser.setBalance(Double.parseDouble(request.getParameter("balance")));
                    userService.createUser(nextUser);
                    break;
                }
                case "update": {
                    User nextUser = new User();
                    nextUser.setUserId(Integer.parseInt(request.getParameter("userId")));
                    nextUser.setFirstName(request.getParameter("firstName"));
                    nextUser.setLastname(request.getParameter("lastName"));
                    nextUser.setBalance(Double.parseDouble(request.getParameter("balance")));
                    userService.updateUser(nextUser);
                    break;
                }
                case "delete": {
                    int userId = Integer.parseInt(request.getParameter("userId"));
                    userService.deleteUser(userId);
                    break;
                }
            }
        } catch (Exception ex) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>An error occurred: " + ex.getMessage() + "</h2>");
            out.println("<pre>");
            ex.printStackTrace(out);
            out.println("</pre>");
            out.println("<a href='" + request.getContextPath() + "/users'>Go Back</a>");
            out.println("</body></html>");
            return;
        }
        response.sendRedirect(request.getContextPath() + "/users");
    }
}
