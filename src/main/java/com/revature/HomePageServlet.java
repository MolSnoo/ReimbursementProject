package com.revature;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class HomePageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        // Ensure that the page isn't cached so that the user can't access the wrong account type after logging out.
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma", "no-cache");   // HTTP 1.0
        response.setDateHeader("Expires", 0);   // Proxies
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session != null) {
            String userType = (String) session.getAttribute("user_type");
            if (userType.equals("EMPLOYEE")) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ehomepage.html");
                dispatcher.forward(request, response);
            }
            else if (userType.equals("MANAGER")) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mhomepage.html");
                dispatcher.forward(request, response);
            }
        }
        else {
            response.sendRedirect(request.getContextPath() + "/loginpage.html");
        }
        out.close();
    }
}
