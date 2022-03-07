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
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user.getType().equals("EMPLOYEE")) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ehomepage.html");
                dispatcher.forward(request, response);
            }
            else if (user.getType().equals("MANAGER")) {
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
