package com.shop.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sub/")
public class SubController {
    
    @GetMapping("product.do")
    public String product() throws Exception {
        return "sub/product";
    }
    @GetMapping("technology.do")
    public String technology() throws Exception {
        return "sub/technology";
    }
    @GetMapping("esg.do")
    public String esg() throws Exception {
        return "sub/esg";
    }
    @GetMapping("company.do")
    public String company() throws Exception {
        return "sub/company";
    }

    @GetMapping("invest.do")
    public String invest() throws Exception {
        return "sub/invest";
    }

    @GetMapping("sitemap.do")
    public String sitemap() throws Exception {
        return "sub/sitemap";
    }



}
