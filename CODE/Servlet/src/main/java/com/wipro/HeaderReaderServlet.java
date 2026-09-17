package com.wipro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headerTest")
public class HeaderReaderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Servlet Header Reader</title></head>");
        out.println("<body>");

        out.println("<h1>Received Request Headers:</h1>");

        // User-Agent
        String userAgent = request.getHeader("User-Agent");

        if (userAgent != null && !userAgent.isEmpty()) {
            out.println("<p><strong>User Agent:</strong> "
                    + userAgent + "</p>");
        } else {
            out.println("<p><strong>User Agent:</strong> Not found.</p>");
        }

        // Content-Type
        String contentType = request.getHeader("Content-Type");

        if (contentType != null && !contentType.isEmpty()) {
            out.println("<p><strong>Content Type:</strong> "
                    + contentType + "</p>");
        } else {
            out.println("<p><strong>Content Type:</strong> Not found.</p>");
        }

        // All headers
        out.println("<h2>All Headers</h2>");

        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {

            String name = headerNames.nextElement();

            String value = request.getHeader(name);

            out.println("<p><strong>"
                    + name
                    + ":</strong> "
                    + value
                    + "</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}