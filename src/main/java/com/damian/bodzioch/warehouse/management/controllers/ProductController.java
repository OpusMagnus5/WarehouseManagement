package com.damian.bodzioch.warehouse.management.controllers;

import com.damian.bodzioch.warehouse.management.database.IProductDAO;
import com.damian.bodzioch.warehouse.management.services.ILoginService;
import com.damian.bodzioch.warehouse.management.services.IProductService;
import com.damian.bodzioch.warehouse.management.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class ProductController {
    @Resource
    SessionObject sessionObject;

    @Autowired
    ILoginService loginService;

    @Autowired
    IProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products(Model model){
        if (loginService.isLogged().isEmpty()){
            return "redirect:/login";
        }
        model.addAttribute("productDatabase", this.productService.getListProduct());
        model.addAttribute("sessionObject", this.sessionObject);
        return "products.html";
    }
}
