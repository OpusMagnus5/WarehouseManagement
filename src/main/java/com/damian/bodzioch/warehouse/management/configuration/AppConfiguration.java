package com.damian.bodzioch.warehouse.management.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan("com.damian.bodzioch.warehouse.management")
public class AppConfiguration {

    @Bean
    public Connection connection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse_management", "root", "");
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
}
