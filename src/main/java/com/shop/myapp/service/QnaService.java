package com.shop.myapp.service;

import java.util.List;

import com.shop.myapp.dto.QnaDTO;

public interface QnaService {
    public List<QnaDTO> qnaList();

    public QnaDTO qnaDetail(QnaDTO dto);

    public QnaDTO qnaDetail2(QnaDTO dto);

    public void qnaQInsert(QnaDTO dto);

    public void qnaAInsert(QnaDTO dto);

    public void qnaDelete(int parno);
}
