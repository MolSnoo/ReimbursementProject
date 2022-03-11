package com.revature;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class ViewInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        //response.sendRedirect(request.getContextPath() + "/ehomepage.jsp");
        getServletContext().getRequestDispatcher("/viewinfo.jsp");
    }
}
