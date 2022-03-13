package com.revature;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class UpdateInfoServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RequestDispatcher header = request.getRequestDispatcher("/templates/header.jsp");
        header.include(request, response);
        out.println("<h1 class=\"center\">Update Employee Info Page</h1>");
        out.println("<br><br>");

        HttpSession session = request.getSession(false);
        int userId = (int) session.getAttribute("user_id");
        UserDao userDao = UserDaoFactory.getUserDao();
        User currentUser = userDao.getUser(userId);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        currentUser.setName(name);
        currentUser.setEmail(email);
        userDao.updateUser(currentUser);

        out.println("<p class=\"center\">Successfully updated info.</p>");

        RequestDispatcher footer = request.getRequestDispatcher("/templates/footer.jsp");
        footer.include(request, response);

        out.close();

    }
}
