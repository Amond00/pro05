package com.shop.myapp.service;

import java.util.List;

import com.shop.myapp.dto.CartDTO;

public interface CartService {
    public List<CartDTO> cartList(String sid);
}
