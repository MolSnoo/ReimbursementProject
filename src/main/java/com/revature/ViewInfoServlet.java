package com.revature;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class ViewInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RequestDispatcher header = request.getRequestDispatcher("/templates/header.jsp");
        header.include(request, response);
        out.println("<h1 class=\"center\">Employee Information Page</h1>");
        out.println("<br><br>");

        HttpSession session = request.getSession(false);
        int userId = (int) session.getAttribute("user_id");
        UserDao userDao = UserDaoFactory.getUserDao();
        User currentUser = userDao.getUser(userId);

        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Id</th>");
        out.println("<th>Name</th>");
        out.println("<th>Email</th>");
        out.println("<th>Employee Type</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        out.println("<tr>");
        out.println("<td>" + currentUser.getId() + "</td>");
        out.println("<td>" + currentUser.getName() + "</td>");
        out.println("<td>" + currentUser.getEmail() + "</td>");
        out.println("<td>" + currentUser.getType() + "</td>");
        out.println("</tr>");
        out.println("</tbody>");
        out.println("</table>");

        RequestDispatcher footer = request.getRequestDispatcher("/templates/footer.jsp");
        footer.include(request, response);

        out.close();

    }
}
