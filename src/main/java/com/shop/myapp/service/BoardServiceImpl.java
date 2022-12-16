package com.shop.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.myapp.dao.BoardDAO;
import com.shop.myapp.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;

    @Override
    public List<BoardDTO> boardList() {
        return boardDAO.boardList();
    }

    @Override
    public BoardDTO boardDetail(BoardDTO boarddto) {
        return boardDAO.boardDetail(boarddto);
    }
}
