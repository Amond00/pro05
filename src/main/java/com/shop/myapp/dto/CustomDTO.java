package com.shop.myapp.dto;

import lombok.Data;

@Data
public class CustomDTO {
    private String id;
    private String pw;
    private String name;
    private String email;
    private String address;
    private String tel;
    private String regDate;
    private int visited;
}
