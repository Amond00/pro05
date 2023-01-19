package com.shop.myapp.dto;

import lombok.Data;

@Data
public class QnaDTO {
    private int no; // 글번호
    private String title; // 질문 제목
    private String content; // 질문 내용
    private String author; // 작성자 아이디
    private String resdate; // 작성일
    private int lev; // 깊이 (질문인가 답변인가)
    private int parno; // 부모글 번호(공통번호)
}
