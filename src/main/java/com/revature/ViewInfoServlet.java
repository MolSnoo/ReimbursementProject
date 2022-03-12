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
        //response.sendRedirect(request.getContextPath() + "/ehomepage.jsp");
        getServletContext().getRequestDispatcher("/viewinfo.jsp");
        PrintWriter out = response.getWriter();

//        RequestDispatcher header = request.getRequestDispatcher("/templates/header.jsp");
//        header.include(request, response);
//        RequestDispatcher tableHeader = request.getRequestDispatcher("/templates/table-header.jsp");
//        tableHeader.include(request, response);

        UserDao userDao = UserDaoFactory.getUserDao();
        User currentuser = new User();
        //List<User> users = UserDao.getUsers();
        //user = UserDao.getUser(2);
        //for (User user : users) {
            //System.out.println(currentuser);
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>Name</th>");
            out.println("<th>Email</th>");
            out.println("<th>Employee Type</th>");
            out.println("</tr>");
            out.println("<tr>");
//          out.println("<td>" + currentuser.getId() + "</td>");
            out.println("<td>" + userDao.getUser(currentuser.getId()) + "</td>");
            out.println("<td>" + currentuser.getName() + "</td>");
            out.println("<td>" + currentuser.getEmail() + "</td>");
            out.println("<td>" + currentuser.getType() + "</td>");
            out.println("</tr>");
        //}

//        RequestDispatcher tableFooter = request.getRequestDispatcher("/templates/table-footer.jsp");
//        tableFooter.include(request, response);
//        RequestDispatcher footer = request.getRequestDispatcher("/templates/footer.jsp");
//        footer.include(request, response);
        out.close();

    }
}
