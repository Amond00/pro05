package com.shop.myapp.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.myapp.dto.CustomDTO;
import com.shop.myapp.service.CustomService;

@Controller
@RequestMapping(value = "/custom/")
public class CustomController {

    @Autowired
    CustomService customService;

    @Autowired
    HttpSession session;

    // 로그인폼 이동, 로그인 처리
    @RequestMapping("loginForm.do")
    public String customLoginFrom() throws Exception {
        return "custom/loginForm";
    }

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public String CustomLogin(@RequestParam String id, @RequestParam String pw) throws Exception {
        CustomDTO dto = new CustomDTO();
        dto.setId(id);
        dto.setPw(pw);
        CustomDTO login = customService.login(dto);
        if (login != null) {
            session.setAttribute("sid", id);
            return "redirect:/";
        } else {
            String massage = "아이디 또는 비밀번호가 맞지 않습니다.";
            session.setAttribute("massage", massage);
            return "redirect:/custom/loginForm.do";
        }
    }

    // 로그아웃
    @RequestMapping("logout.do")
    public String logoutsession(HttpSession session) throws Exception {
        session.invalidate();
        return "redirect:/";
    }

    // 회원가입 동의 페이지 이동
    @RequestMapping("agree.do")
    public String customagree() throws Exception {
        return "custom/agree";
    }

    // 회원가입 페이지 이동
    @RequestMapping("joinForm.do")
    public String customjoinFrom() throws Exception {
        return "custom/joinForm";
    }

    // 회원 가입 - Ajax로 아이디 중복 체크
    @RequestMapping(value = "idCheck.do", method = RequestMethod.POST)
    public void idCheck(HttpServletResponse response, HttpServletRequest request, Model model) throws Exception {
        String cusid = request.getParameter("cusid");
        boolean result = false;
        CustomDTO cusdto = new CustomDTO();
        cusdto = customService.idCheck(cusid);

        if (cusdto != null) { // 이미 있는 아이디임
            result = false;
        } else {
            result = true;
        }

        JSONObject json = new JSONObject();
        json.put("result", result);
        PrintWriter out = response.getWriter();
        out.println(json.toString());
    }

    // 회원가입 처리
    @RequestMapping(value = "join.do", method = RequestMethod.POST)
    public String customJoin(HttpServletRequest request, Model model, CustomDTO cusdto) throws Exception {
        cusdto.setId(request.getParameter("cusid"));
        cusdto.setPw(request.getParameter("cuspw"));
        cusdto.setName(request.getParameter("cusname"));
        cusdto.setAddress(request.getParameter("address"));
        cusdto.setTel(request.getParameter("tel"));
        CustomDTO join = customService.customJoin(cusdto);
        if (join != null) {
            return "redirect:/";
        } else {
            return "redirect:/custom/joinForm.do";
        }
    }

    // 회원목록

    // 회원탈퇴
    @GetMapping("delete.do")
    public String customdelete() throws Exception {
        return "redirect:/";
    }
}
