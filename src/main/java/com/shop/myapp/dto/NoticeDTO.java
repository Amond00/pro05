package com.shop.myapp.dto;

import lombok.Data;

@Data
public class NoticeDTO {
    int notino;
    String title;
    String content;
    String author;
    String resdate;
    int visitied;

}
