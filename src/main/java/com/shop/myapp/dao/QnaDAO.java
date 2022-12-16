package com.shop.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.myapp.dto.QnaDTO;

@Mapper
@Repository
public interface QnaDAO {
    public List<QnaDTO> qnaList();

    public QnaDTO qnaDetail(QnaDTO dto);

    public QnaDTO qnaDetail2(QnaDTO dto);

    public void qnaQInsert(QnaDTO dto);

    public void qnaAInsert(QnaDTO dto);

    public void qnaDelete(int parno);
}
