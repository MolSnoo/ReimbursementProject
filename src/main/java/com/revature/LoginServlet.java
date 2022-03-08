package com.revature;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDao userDao = UserDaoFactory.getUserDao();
        User user = userDao.login(email, password);
        if (user == null) {
            out.println("<span style=\"color:red\">Email address or password is incorrect.</span>");
            RequestDispatcher rd = request.getRequestDispatcher("/loginpage.html");
            rd.include(request, response);
        }
        else {
            HttpSession session = request.getSession();
            session.setAttribute("user_id", user.getId());
            session.setAttribute("user_name", user.getName());
            session.setAttribute("user_type", user.getType());
            response.sendRedirect(request.getContextPath());
        }
        out.close();
    }
}
