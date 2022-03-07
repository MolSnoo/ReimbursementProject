package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDaoImpl implements UserDao {
    Configuration config;
    SessionFactory factory;

    public UserDaoImpl() {
        this.config = new Configuration();
        config.configure("hibernate.cfg.xml");
        this.factory = config.buildSessionFactory();
    }


    @Override
    public User login(String email, String password) {
        return null;
    }
}
