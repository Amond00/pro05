package com.shop.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.myapp.dto.NoticeDTO;
import com.shop.myapp.service.NoticeService;

@Controller
@RequestMapping(value = "/notice/")
public class NoticeController {
    // 자유게시판
    @Autowired
    NoticeService noticeService;

    // 자유게시판 목록
    @GetMapping("noticeList.do")
    public String getnoticeList(Model model) throws Exception {
        List<NoticeDTO> noticeList = noticeService.noticeList();
        model.addAttribute("noticeList", noticeList);
        return "notice/noticeList";
    }

    // 자유게시판 상세보기
    @GetMapping("noticeDetail.do")
    public String getnoticeDetail(Model model, @RequestParam int notino) throws Exception {
        System.out.println("자유게시판 상세보기 조회번호:" + notino);
        NoticeDTO notidto = new NoticeDTO();
        notidto.setNotino(notino);
        NoticeDTO noticeDetail = noticeService.noticeDetail(notidto);
        model.addAttribute("noticeDetail", noticeDetail);
        return "notice/noticeDetail";
    }
}
