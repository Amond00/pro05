package com.shop.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.myapp.dao.QnaDAO;
import com.shop.myapp.dto.QnaDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnaServiceImpl implements QnaService {

    private final QnaDAO qnaDAO;

    @Override
    public List<QnaDTO> qnaList() {
        return qnaDAO.qnaList();
    }

    @Override
    public QnaDTO qnaDetail(QnaDTO qnadto) {
        return qnaDAO.qnaDetail(qnadto);
    }

    @Override
    public QnaDTO qnaDetail2(QnaDTO qnadto) {
        return qnaDAO.qnaDetail2(qnadto);
    }

    @Override
    public void qnaQInsert(QnaDTO qnadto) {
        qnaDAO.qnaQInsert(qnadto);
    }

    @Override
    public void qnaAInsert(QnaDTO qnadto) {
        qnaDAO.qnaAInsert(qnadto);
    }

    @Override
    public void qnaDelete(int parno) {
        qnaDAO.qnaDelete(parno);
    }
}
