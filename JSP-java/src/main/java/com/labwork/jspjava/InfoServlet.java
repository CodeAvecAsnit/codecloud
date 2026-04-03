package com.labwork.jspjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        for (int i = 1; i <= 10; i++) {
            out.println("<p>" + i + ". Java is one of the powerful programming languages!</p>");
        }
        LocalDateTime now = LocalDateTime.now();
        out.println("<h3>Current Date and Time: " + now + "</h3>");
        out.println("<h3>Name: Asnit Bakhati</h3>");
        out.println("<h3>Roll No: 23081031</h3>");
        out.println("</body></html>");
    }
}