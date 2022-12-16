package com.shop.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.myapp.dao.CartDAO;
import com.shop.myapp.dto.CartDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartDAO cartDAO;

    @Override
    public List<CartDTO> cartList(String sid) {
        return cartDAO.cartList(sid);
    }
}
