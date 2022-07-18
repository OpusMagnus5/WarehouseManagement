package com.damian.bodzioch.warehouse.management.controllers;

import com.damian.bodzioch.warehouse.management.model.Message;
import com.damian.bodzioch.warehouse.management.services.iplm.ContactService;
import com.damian.bodzioch.warehouse.management.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class ContactController {
    @Resource
    SessionObject sessionObject;

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model){
        model.addAttribute("message", new Message());
        model.addAttribute("sessionObject", this.sessionObject);
        return "contact.html";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String contact(@ModelAttribute Message message){
        this.contactService.sendMessage(message.getFirstName(), message.getLastName(), message.getTopic(), message.getContent());
        return "redirect:/contact";
    }


}
