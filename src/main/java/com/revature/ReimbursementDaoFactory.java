package com.revature;

public class ReimbursementDaoFactory {
    private static ReimbursementDao dao = null;

    private ReimbursementDaoFactory() {}

    public static ReimbursementDao getReimbursementDao() {
        if (dao == null) {
            dao = new ReimbursementDaoImpl();
        }
        return dao;
    }
}
