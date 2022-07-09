package com.damian.bodzioch.warehouse.management.controllers;

import com.damian.bodzioch.warehouse.management.session.SessionObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class BasicController {
    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model){
        model.addAttribute("sessionObject", this.sessionObject);
        return "main.html";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(){
        return "redirect:/main";
    }
}
