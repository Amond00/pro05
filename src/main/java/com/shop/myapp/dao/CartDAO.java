package com.shop.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.myapp.dto.CartDTO;

@Mapper
@Repository
public interface CartDAO {
    List<CartDTO> cartList(String sid);
}
