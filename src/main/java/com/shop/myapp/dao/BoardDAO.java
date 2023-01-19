package com.shop.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.myapp.dto.BoardDTO;

@Mapper
@Repository
public interface BoardDAO {
    List<BoardDTO> boardList();
    BoardDTO boardDetail(BoardDTO dto);
}
