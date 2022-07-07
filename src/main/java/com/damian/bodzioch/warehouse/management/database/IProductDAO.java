package com.damian.bodzioch.warehouse.management.database;

import com.damian.bodzioch.warehouse.management.model.Product;

import java.util.ArrayList;

public interface IProductDAO {
    ArrayList<Product> getProductsDatabase();
}
