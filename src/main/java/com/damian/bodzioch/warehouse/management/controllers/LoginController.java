package com.damian.bodzioch.warehouse.management.controllers;

import com.damian.bodzioch.warehouse.management.exceptions.LoginOrPasswordDoNotMatch;
import com.damian.bodzioch.warehouse.management.model.User;
import com.damian.bodzioch.warehouse.management.services.iplm.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logIn(Model model){
        model.addAttribute("user", new User());
        return "log-in.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logIn(@ModelAttribute User user){
        try {
            loginService.logIn(user);
        }catch (LoginOrPasswordDoNotMatch loginOrPasswordDoNotMatch){
            return "log-in.html";
        }
        return "redirect:/main";
    }
}
