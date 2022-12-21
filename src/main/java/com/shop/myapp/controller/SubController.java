package com.shop.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sub/")
public class SubController {

    @GetMapping("sub1.do")
    public String getSub1() throws Exception {
        return "sub/sub1";
    }

    @GetMapping("sub2.do")
    public String getSub2() throws Exception {
        return "sub/sub2";
    }

    @GetMapping("sub3.do")
    public String getSub3() throws Exception {
        return "sub/sub3";
    }

}
