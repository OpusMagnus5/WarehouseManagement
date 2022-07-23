package com.damian.bodzioch.warehouse.management.database.jdbc;

import com.damian.bodzioch.warehouse.management.database.IUserDAO;
import com.damian.bodzioch.warehouse.management.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class UserDAOImpl implements IUserDAO {

    @Autowired
    Connection connection;

    public ArrayList<User> getUserDatabase(){
        ArrayList<User> users = new ArrayList<>();

        try {
            String sql = "SELECT * FROM users;";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                users.add(new User(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password")));
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Metoda getUserDatabase");
        }
        return users;
    }

    public void addUser(User user){
        try {
            String sql = "INSERT INTO users (login, password) VALUES (?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getLogin());
            ps.setString(2, DigestUtils.md5Hex(user.getPassword()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            user.setId(rs.getInt(1));
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Metoda addUser");
        }
    }
}
