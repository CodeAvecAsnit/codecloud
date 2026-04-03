package com.labwork.jspjava;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class SimpleInterestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            double principal = Double.parseDouble(request.getParameter("principal"));
            double time = Double.parseDouble(request.getParameter("time"));
            double rate = Double.parseDouble(request.getParameter("rate"));

            double simpleInterest = (principal * time * rate) / 100;

            out.println("<html><body>");
            out.println("<h2>Simple Interest Calculation</h2>");
            out.println("<p>Principal: " + principal + "</p>");
            out.println("<p>Time (years): " + time + "</p>");
            out.println("<p>Rate of Interest: " + rate + "%</p>");
            out.println("<h3>Simple Interest: " + simpleInterest + "</h3>");
            out.println("<a href='index.html'>Calculate Again</a>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<h3>Invalid input! Please enter numbers only.</h3>");
            out.println("<a href='index.html'>Go Back</a>");
            out.println("</body></html>");
        }
    }
}