package com.damian.bodzioch.warehouse.management.controllers;

import com.damian.bodzioch.warehouse.management.database.IProductDAO;
import com.damian.bodzioch.warehouse.management.services.iplm.LoginService;
import com.damian.bodzioch.warehouse.management.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class ProductController {

    @Autowired
    IProductDAO productDatabase;

    @Autowired
    LoginService loginService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products(Model model){
        model.addAttribute("productDatabase", productDatabase.getProductsDatabase());
        model.addAttribute("sessionObject", this.sessionObject);
        return "products.html";
    }
}
