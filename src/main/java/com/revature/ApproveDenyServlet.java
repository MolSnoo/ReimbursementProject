package com.revature;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class ApproveDenyServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RequestDispatcher header = request.getRequestDispatcher("/templates/header.jsp");
        header.include(request, response);
        out.println("<h1 class=\"center\">Approve/Deny Reimbursement Request Page</h1>");

        ReimbursementDao reimbursementDao = ReimbursementDaoFactory.getReimbursementDao();
        int reimbursementId = Integer.parseInt(request.getParameter("id"));
        Reimbursement reimbursement = reimbursementDao.getReimbursement(reimbursementId);
        if (reimbursement == null) {
            out.println("<p class=\"center\">The reimbursement id entered is invalid.</p>");
        }
        else {
            String action = request.getParameter("action");
            if (action.equals("APPROVE")) {
                reimbursement.setApproved(true);
                reimbursementDao.updateReimbursement(reimbursement);
                out.println("<p class=\"center\">Successfully approved reimbursement request.</p>");
            }
            else {
                reimbursementDao.deleteReimbursement(reimbursement);
                out.println("<p class=\"center\">Successfully rejected reimbursement request.</p>");
            }
        }

        RequestDispatcher footer = request.getRequestDispatcher("/templates/footer.jsp");
        footer.include(request, response);

        out.close();

    }
}
