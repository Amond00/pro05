package com.shop.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String goMain(HttpServletRequest request) {
        return "Ok Spring Boot Main";
    }

}
