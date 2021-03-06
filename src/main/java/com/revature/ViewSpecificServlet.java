package com.revature;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ViewSpecificServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RequestDispatcher header = request.getRequestDispatcher("/templates/header.jsp");
        header.include(request, response);
        out.println("<h1 class=\"center\">View Specific Employee's Reimbursement Requests Page</h1>");

        UserDao userDao = UserDaoFactory.getUserDao();
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userDao.getUser(userId);
        if (user == null) {
            out.println("<p class=\"center\">The employee id entered is invalid.</p>");
        }
        else {
            ReimbursementDao reimbursementDao = ReimbursementDaoFactory.getReimbursementDao();
            List<Reimbursement> reimbursements = reimbursementDao.getPendingReimbursements(userId);
            List<Reimbursement> resolvedReimbursements = reimbursementDao.getResolvedReimbursements(userId);
            reimbursements.addAll(resolvedReimbursements);

            out.println("<table>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>Amount</th>");
            out.println("<th>Status</th>");
            out.println("<th>Employee Id</th>");
            out.println("<th>Employee Name</th>");
            out.println("<th>Employee Email</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("</tbody>");
            for (int i = 0; i < reimbursements.size(); i++) {
                out.println("<tr>");
                out.println("<td>" + reimbursements.get(i).getId() + "</td>");
                out.println("<td>" + reimbursements.get(i).getAmount() + "</td>");
                out.println("<td>" + (reimbursements.get(i).isApproved() ? "APPROVED" : "PENDING") + "</td>");
                out.println("<td>" + reimbursements.get(i).getUser().getId() + "</td>");
                out.println("<td>" + reimbursements.get(i).getUser().getName() + "</td>");
                out.println("<td>" + reimbursements.get(i).getUser().getEmail() + "</td>");
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
        }

        RequestDispatcher footer = request.getRequestDispatcher("/templates/footer.jsp");
        footer.include(request, response);

        out.close();

    }
}
