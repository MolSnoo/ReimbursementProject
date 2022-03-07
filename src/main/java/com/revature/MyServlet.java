package com.revature;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
    ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        System.out.println("Creating object...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servicing...");
    }

    @Override
    public String getServletInfo() {
        return "this servlet created by admin";
    }

    @Override
    public void destroy() {
        System.out.println("going to destroy servlet object...");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cssTag="<link rel='stylesheet' type='text/css' href='css/style.css'>";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // getting the value from query string
        String name = request.getParameter("name");
        out.println("Welcome : "+ name);

        HttpSession session = request.getSession();
        session.setAttribute("uname", name);

        out.println("<a href='EmpHome'>Click Here</a>");
        out.close();
    }

}
