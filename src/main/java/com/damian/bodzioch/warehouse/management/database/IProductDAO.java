package com.damian.bodzioch.warehouse.management.database;

import com.damian.bodzioch.warehouse.management.model.Product;

import java.util.ArrayList;
import java.util.Optional;

public interface IProductDAO {
    ArrayList<Product> getProductsDatabase();
    Optional<Product> getProductFromID(int id);
}
