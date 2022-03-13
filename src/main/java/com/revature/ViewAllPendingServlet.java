package com.revature;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ViewAllPendingServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RequestDispatcher header = request.getRequestDispatcher("/templates/header.jsp");
        header.include(request, response);
        out.println("<h1 class=\"center\">All Pending Reimbursement Requests Page</h1>");
        out.println("<br><br>");

        ReimbursementDao reimbursementDao = ReimbursementDaoFactory.getReimbursementDao();
        List<Reimbursement> reimbursements = reimbursementDao.getPendingReimbursements();

        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Id</th>");
        out.println("<th>User Name</th>");
        out.println("<th>User Email</th>");
        out.println("<th>User Type</th>");
        out.println("<th>Amount</th>");
        out.println("<th>Status</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("</tbody>");
        for (int i = 0; i < reimbursements.size(); i++) {
            out.println("<tr>");
            out.println("<td>" + reimbursements.get(i).getId() + "</td>");
            out.println("<td>" + reimbursements.get(i).getUser().getName() + "</td>");
            out.println("<td>" + reimbursements.get(i).getUser().getEmail() + "</td>");
            out.println("<td>" + reimbursements.get(i).getUser().getType() + "</td>");
            out.println("<td>" + reimbursements.get(i).getAmount() + "</td>");
            out.println("<td>PENDING</td>");
            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");

        RequestDispatcher footer = request.getRequestDispatcher("/templates/footer.jsp");
        footer.include(request, response);

        out.close();

    }
}
