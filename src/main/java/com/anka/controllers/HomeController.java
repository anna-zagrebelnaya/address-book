package com.anka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Anka on 11.04.2015.
 */
@Controller
public class HomeController {

    @RequestMapping({"/","/home"})
    public String showHomePage(Map<String, Object> model) {
        return "home";
    }

}
