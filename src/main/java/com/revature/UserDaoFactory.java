package com.revature;

public class UserDaoFactory {
    private static UserDao dao = null;

    private UserDaoFactory() {}

    public static UserDao getUserDao() {
        if (dao == null) {
            dao = new UserDaoImpl();
        }
        return dao;
    }
}