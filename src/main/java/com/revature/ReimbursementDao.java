package com.revature;

import java.util.List;

public interface ReimbursementDao {
    void submitReimbursement(Reimbursement reimbursement);
    void updateReimbursement(Reimbursement reimbursement);
    List<Reimbursement> getPendingReimbursements();
    List<Reimbursement> getPendingReimbursements(int userId);
    List<Reimbursement> getResolvedReimbursements();
    List<Reimbursement> getResolvedReimbursements(int userId);
}
