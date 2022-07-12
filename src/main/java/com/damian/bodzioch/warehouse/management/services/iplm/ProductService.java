package com.damian.bodzioch.warehouse.management.services.iplm;

import com.damian.bodzioch.warehouse.management.database.IProductDAO;
import com.damian.bodzioch.warehouse.management.model.Product;
import com.damian.bodzioch.warehouse.management.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductDAO productDAO;

    public ArrayList<Product> getListProduct(){
        return productDAO.getProductsDatabase();
    }
}
