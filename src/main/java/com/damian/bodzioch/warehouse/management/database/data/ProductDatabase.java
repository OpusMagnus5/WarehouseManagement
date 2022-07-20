package com.damian.bodzioch.warehouse.management.database.data;

import com.damian.bodzioch.warehouse.management.database.IProductDAO;
import com.damian.bodzioch.warehouse.management.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class ProductDatabase implements IProductDAO {
    private ArrayList<Product> productDatabase = new ArrayList<>();

    public ProductDatabase(){
        this.productDatabase.add(new Product(1, "Xiaomi Redmi Note 10S 6/128GB Onyx Gray", 8, "653631"));
        this.productDatabase.add(new Product(2, "realme C21Y 4+64GB Cross Black", 5, "691815"));
        this.productDatabase.add(new Product(3, "ASUS ZenFone 8 8/128GB Black", 13, "650433"));
        this.productDatabase.add(new Product(4, "Apple iPhone 11 64GB White", 2, "602827"));
        this.productDatabase.add(new Product(5, "Samsung Galaxy A32 SM-A325F 4/128GB Black", 7, "615050"));
        this.productDatabase.add(new Product(6, "Motorola Moto G82 5G 6/128GB Meteorite Grey", 3, "1041761"));
    }

    public ArrayList<Product> getProductsDatabase() {
        return productDatabase;
    }

    public Optional<Product> getProductFromID(int id){
        for (Product product : this.productDatabase){
            if (product.getId() == id){
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }
}
