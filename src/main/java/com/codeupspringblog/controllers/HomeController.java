package com.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController{
    @GetMapping("/")

    public String landingPage() {
        return "home";
    }
}
//the return "home" above where home refers to the html page name. otherwise html won't open.