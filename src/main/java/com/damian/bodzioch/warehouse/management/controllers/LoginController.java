package com.damian.bodzioch.warehouse.management.controllers;

import com.damian.bodzioch.warehouse.management.exceptions.LoginOrPasswordDoNotMatch;
import com.damian.bodzioch.warehouse.management.model.User;
import com.damian.bodzioch.warehouse.management.services.ILoginService;
import com.damian.bodzioch.warehouse.management.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class LoginController {
    @Autowired
    ILoginService loginService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logIn(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("sessionObject", this.sessionObject);
        return "log-in.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logIn(@ModelAttribute User user){
        try {
            loginService.logIn(user);
        }catch (LoginOrPasswordDoNotMatch ex){
            return "redirect:/login";
        }
        return "redirect:/main";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        this.sessionObject.setUser(null);
        return "redirect:/login";
    }
}
