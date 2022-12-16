package com.shop.myapp.dto;

import lombok.Data;

@Data
public class CustomDTO {
    String cusId;
    String cusPw;
    String cusName;
    String address;
    String tel;
    String regDate;
    int point;
    int level;
    int visited;
}
