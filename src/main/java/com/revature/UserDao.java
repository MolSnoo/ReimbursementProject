package com.revature;

public interface UserDao {
    User login(String email, String password);
}