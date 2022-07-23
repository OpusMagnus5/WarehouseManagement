package com.damian.bodzioch.warehouse.management.database.data;

import com.damian.bodzioch.warehouse.management.database.IUserDAO;
import com.damian.bodzioch.warehouse.management.exceptions.NotImplementedMethod;
import com.damian.bodzioch.warehouse.management.model.User;

import java.util.ArrayList;


public class UserDatabase implements IUserDAO {
    private ArrayList<User> userDatabase = new ArrayList<>();

    public UserDatabase(){
        this.userDatabase.add(new User(1, "admin", "admin"));
    }

    public ArrayList<User> getUserDatabase() {
        return userDatabase;
    }

    public void addUser(User user){
        throw new NotImplementedMethod();
    }
}
