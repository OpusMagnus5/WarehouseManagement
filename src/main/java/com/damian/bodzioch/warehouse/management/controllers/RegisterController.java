package com.damian.bodzioch.warehouse.management.controllers;

import com.damian.bodzioch.warehouse.management.exceptions.LoginTooShort;
import com.damian.bodzioch.warehouse.management.exceptions.PasswordDoNotMatch;
import com.damian.bodzioch.warehouse.management.exceptions.PasswordTooShort;
import com.damian.bodzioch.warehouse.management.model.User;
import com.damian.bodzioch.warehouse.management.services.IRegisterService;
import com.damian.bodzioch.warehouse.management.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class RegisterController {
    @Resource
    SessionObject sessionObject;

    @Autowired
    IRegisterService registerService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("sessionObject", this.sessionObject);
        return "register.html";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute User user, @RequestParam String repeatPassword){
        try {
            this.registerService.validationForm(user, repeatPassword);
        }catch (LoginTooShort | PasswordDoNotMatch | PasswordTooShort ex){
            return "redirect:/register";
        }
        this.registerService.addNewUser(user);
        return "redirect:/main";
    }
}
//TODO dorobić javascript do walidacji