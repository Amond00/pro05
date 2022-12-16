package com.shop.myapp.dto;

import lombok.Data;

@Data
public class CartDTO {
    private int cartNo;
    private String cusId;
    private int proNo;
    private int amount;
}
