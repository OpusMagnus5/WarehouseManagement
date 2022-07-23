package com.damian.bodzioch.warehouse.management.database.jdbc;

import com.damian.bodzioch.warehouse.management.database.IProductDAO;
import com.damian.bodzioch.warehouse.management.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class ProductDAOImpl implements IProductDAO {

    @Autowired
    Connection connection;

    @Override
    public ArrayList<Product> getProductsDatabase(){
        ArrayList<Product> products = new ArrayList<>();

        try {
            String sql = "SELECT * FROM products;";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                products.add(new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getInt("code")));
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Metoda getProductDatabase");
        }
        return products;
    }

    @Override
    public Optional<Product> getProductByID(int id){

        try {
            String sql = "SELECT * FROM products WHERE id = ?;";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return Optional.of(new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getInt("code")));
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Metoda getProductByID");
        }
        return Optional.empty();
    }
}
