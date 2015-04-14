package com.anka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Anka on 11.04.2015.
 */
@Controller
public class AddressBookController {

    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam("user") String user, ModelMap model) {
        //TODO: check user in base
        setUser(user);
        model.addAttribute("user", user);
        return "address-book";
    }

}
