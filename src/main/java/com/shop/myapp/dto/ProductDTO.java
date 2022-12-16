package com.shop.myapp.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private int proNo;
    private int cateNo;
    private String proName;
    private String proSpec;
    private int proPrice;
}
