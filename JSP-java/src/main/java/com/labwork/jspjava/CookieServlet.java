package com.labwork.jspjava;
import com.labwork.jspjava.jdbc.SessionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    private SessionService sessionService;

    @Override
    public void init() throws ServletException {
        this.sessionService = new SessionService(new Random(), new HashMap<>());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String userInput = request.getParameter("sessionValue");
        String resultMessage = "";
        if ("generate".equals(action)) {
            String token = sessionService.createToken(userInput);
            Cookie c = new Cookie("my_token", token);
            c.setMaxAge(3600);
            response.addCookie(c);
            resultMessage = "Cookie Stored! Token: " + token;
        } else if ("check".equals(action)) {
            String foundToken = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if ("my_token".equals(c.getName())) {
                        foundToken = c.getValue();
                    }
                }
            }
            if (foundToken != null) {
                String val = sessionService.getValue(foundToken);
                resultMessage = "Found Token: " + foundToken + " | Value: " + val;
            } else {
                resultMessage = "No cookie found!";
            }
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Cookie Magic</title></head><body>");
        out.println("<h2>Cookie & Session Manager</h2>");
        out.println("<form action='cookie' method='post'>");
        out.println("  <input type='text' name='sessionValue' placeholder='Enter value...'>");
        out.println("  <button type='submit' name='action' value='generate'>Generate</button>");
        out.println("  <button type='submit' name='action' value='check'>Check</button>");
        out.println("</form>");
        if (!resultMessage.isEmpty()) {
            out.println("<div style='background:#ffffcc; padding:10px; border:1px solid orange;'>");
            out.println("<strong>Status:</strong> " + resultMessage);
            out.println("</div>");
        }

        out.println("</body></html>");
    }
}