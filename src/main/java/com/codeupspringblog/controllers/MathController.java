package com.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{number1}/and/{number2}")
    @ResponseBody

    public String adding(@PathVariable int number1, @PathVariable int number2) {
        return number1 +" "+ number2 + "=" + (number1 + number2);
    }

    @GetMapping("/subtract/3/from/10")
    @ResponseBody

    public int subtracting() {
        return 10 - 7;
    }

    @GetMapping("/multiply/4/and/5")
    @ResponseBody

    public int multipling() {
        return 4 * 5;
    }

    @GetMapping("/divide/6/by/3")
    @ResponseBody

    public int deviding() {
        return 6/3;
    }
}
