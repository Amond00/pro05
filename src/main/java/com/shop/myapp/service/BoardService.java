package com.shop.myapp.service;

import java.util.List;

import com.shop.myapp.dto.BoardDTO;

public interface BoardService {
    public List<BoardDTO> boardList();

    public BoardDTO boardDetail(BoardDTO boarddto);
}
