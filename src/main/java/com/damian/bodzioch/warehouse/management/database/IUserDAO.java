package com.damian.bodzioch.warehouse.management.database;

import com.damian.bodzioch.warehouse.management.model.User;

import java.util.ArrayList;

public interface IUserDAO {
    ArrayList<User> getUserDatabase();
    void addUser(User user);
}
