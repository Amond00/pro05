package com.shop.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.myapp.dto.BoardDTO;
import com.shop.myapp.service.BoardService;

@Controller
@RequestMapping(value = "/board/")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("boards.do")
    public String boards() throws Exception {
        return "board/boards";
    }

    // 공지게시판 목록
    @GetMapping("boardList.do")
    public String getboardList(Model model) throws Exception {
        List<BoardDTO> boardList = boardService.boardList();
        model.addAttribute("boardList", boardList);
        return "board/boardList";
    }

    // 공지게시판 상세보기
    @GetMapping("boardDetail.do")
    public String getboardDetail(Model model, @RequestParam int no) throws Exception {
        BoardDTO dto = new BoardDTO();
        dto.setNo(no);
        BoardDTO boardDetail = boardService.boardDetail(dto);
        model.addAttribute("boardDetail", boardDetail);
        return "board/boardDetail";
    }
}
