package com.revature;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ViewEmployeesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RequestDispatcher header = request.getRequestDispatcher("/templates/header.jsp");
        header.include(request, response);
        out.println("<h1 class=\"center\">View All Employees Page</h1>");
        out.println("<br><br>");

        UserDao userDao = UserDaoFactory.getUserDao();
        List<User> employees = userDao.getEmployees();

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
        for (int i = 0; i < employees.size(); i++) {
            out.println("<tr>");
            out.println("<td>" + employees.get(i).getId() + "</td>");
            out.println("<td>" + employees.get(i).getName() + "</td>");
            out.println("<td>" + employees.get(i).getEmail() + "</td>");
            out.println("<td>" + employees.get(i).getType() + "</td>");
            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");

        RequestDispatcher footer = request.getRequestDispatcher("/templates/footer.jsp");
        footer.include(request, response);

        out.close();

    }
}
