package com.revature;

import java.util.List;

public interface UserDao {
    void updateUser(User user);
    User login(String email, String password);
    User getUser(int id);
    List<User> getEmployees();
}
