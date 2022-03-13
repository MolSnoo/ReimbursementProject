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

public class ViewPendingServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RequestDispatcher header = request.getRequestDispatcher("/templates/header.jsp");
        header.include(request, response);
        out.println("<h1 class=\"center\">Pending Reimbursement Requests Page</h1>");
        out.println("<br><br>");

        HttpSession session = request.getSession(false);
        int userId = (int) session.getAttribute("user_id");

        ReimbursementDao reimbursementDao = ReimbursementDaoFactory.getReimbursementDao();
        List<Reimbursement> reimbursements = reimbursementDao.getPendingReimbursements(userId);

        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Id</th>");
        out.println("<th>Amount</th>");
        out.println("<th>Status</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        for (int i = 0; i < reimbursements.size(); i++) {
            out.println("<tr>");
            out.println("<td>" + reimbursements.get(i).getId() + "</td>");
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
