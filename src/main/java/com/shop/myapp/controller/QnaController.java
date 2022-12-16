package com.shop.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.myapp.dto.QnaDTO;
import com.shop.myapp.service.QnaService;

@Controller
@RequestMapping(value = "/qna/")
public class QnaController {

    @Autowired
    QnaService qnaService;

    // qna게시판 목록
    @GetMapping("qnaList.do")
    public String getqnaList(Model model) throws Exception {
        List<QnaDTO> qnaList = qnaService.qnaList();
        model.addAttribute("qnaList", qnaList);
        return "qna/qnaList";
    }

    // qna게시판 상세보기
    @GetMapping("qnaDetail.do")
    public String getqnaDetail(Model model, @RequestParam int parno) throws Exception {
        System.out.println("QnA게시판 상세보기 접속 고유번호:" + parno);
        QnaDTO qnadto = new QnaDTO();
        qnadto.setParno(parno);
        QnaDTO qnaDetail = qnaService.qnaDetail(qnadto);
        QnaDTO qnaDetail2 = qnaService.qnaDetail2(qnadto);
        model.addAttribute("qnaDetail", qnaDetail);
        model.addAttribute("qnaDetail2", qnaDetail2);
        return "qna/qnaDetail";
    }

    // qna게시판 질문글 작성폼 및 작성
    @RequestMapping("QqnaInsertForm.do")
    public String qnaQInsertFrom(Model model) throws Exception {
        return "qna/qnaQInsert";
    }

    @PostMapping("qnaQInsert.do")
    public String qnaQInsert(HttpServletRequest request, Model model) throws Exception {
        QnaDTO dto = new QnaDTO();
        dto.setTitle(request.getParameter("title"));
        dto.setContent(request.getParameter("content"));
        dto.setAuthor(request.getParameter("author"));
        qnaService.qnaQInsert(dto);

        return "redirect:/qna/qnaList.do";
    }

    // qna게시판 (관리자)답변글 작성폼 및 작성
    @GetMapping("qnaAInsertForm.do")
    public String qnaAInsertFrom(Model model, @RequestParam int parno) throws Exception {
        QnaDTO qnadto = new QnaDTO();
        qnadto.setParno(parno);
        QnaDTO qnaDetail = qnaService.qnaDetail(qnadto);
        model.addAttribute("qnaDetail", qnaDetail);
        return "qna/qnaAInsert";
    }

    @PostMapping("qnaAInsert.do")
    public String qnaAInsert(HttpServletRequest request, Model model) throws Exception {
        QnaDTO dto = new QnaDTO();
        dto.setTitle(request.getParameter("title"));
        dto.setContent(request.getParameter("content"));
        dto.setParno(Integer.parseInt(request.getParameter("parno")));
        qnaService.qnaAInsert(dto);

        return "redirect:/qna/qnaList.do";
    }

    // qna게시판 글 삭제(질문, 답변 일괄)
    @GetMapping("qnaDelete.do")
    public String qnaDelete(Model model, @RequestParam int parno) throws Exception {
        QnaDTO qnadto = new QnaDTO();
        qnadto.setParno(parno);
        qnaService.qnaDelete(parno);
        return "redirect:/qna/qnaList.do";
    }

    // qna게시판 질문, 답변 수정
}
