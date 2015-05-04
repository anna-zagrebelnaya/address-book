package com.anka.controllers;

import com.anka.domain.User;
import com.anka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookController {

    private User user;

    private UserService userService;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    @Qualifier(value="userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam("user") String user, ModelMap model) {
        setUser(userService.getByName(user));
        if (getUser() == null) {
            return "home";
        }
        model.addAttribute("user", getUser());
        return "address-book";
    }

}
