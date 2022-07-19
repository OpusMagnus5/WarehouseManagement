package com.damian.bodzioch.warehouse.management.controllers;

import com.damian.bodzioch.warehouse.management.services.IBasketService;
import com.damian.bodzioch.warehouse.management.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class BasketController {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IBasketService basketService;

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String basket(Model model){
        model.addAttribute("sessionObject", this.sessionObject);
        return "basket.html";
    }

    @RequestMapping(value = "/basket/add/product/{id}", method = RequestMethod.GET)
    public String addProductToBasket(@PathVariable int id){
        this.basketService.addProductToBasket(id);
        return "redirect:/products";
    }
}
