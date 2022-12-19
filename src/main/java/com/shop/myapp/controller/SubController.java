package com.shop.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sub/")
public class SubController {
    @GetMapping("sub1.do")
    public String sub1() throws Exception {
        return "sub/sub1";
    }

}
