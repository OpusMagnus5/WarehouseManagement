package com.damian.bodzioch.warehouse.management.controllers;

import com.damian.bodzioch.warehouse.management.database.IProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    IProductDAO productDatabase;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products(Model model){
        model.addAttribute("productDatabase", productDatabase.getProductsDatabase());
        return "products.html";
    }
}
