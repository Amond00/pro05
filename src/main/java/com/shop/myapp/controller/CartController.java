package com.shop.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.myapp.dto.CartDTO;
import com.shop.myapp.service.CartService;

@Controller
@RequestMapping(value = "/cart/")
public class CartController {
    // 카트
    @Autowired
    CartService cartService;

    // 카트 목록
    @GetMapping("cartList.do")
    public String getcartList(Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");
        List<CartDTO> cartList = cartService.cartList(sid);
        model.addAttribute("cartList", cartList);
        return "cart/cartList";
    }

}
