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
import com.shop.myapp.util.ScriptUtils;

@Controller
@RequestMapping(value = "/custom/")
public class CustomController {

    @Autowired
    CustomService customService;

    @Autowired
    HttpSession session;

    @Autowired
    ScriptUtils su;

    // 로그인폼 이동, 로그인 처리
    @RequestMapping("loginForm.do")
    public String customLoginFrom() throws Exception {
        return "custom/loginForm";
    }

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public String CustomLogin(@RequestParam String id, @RequestParam String pw, HttpServletResponse response)
            throws Exception {
        CustomDTO dto = new CustomDTO();
        dto.setId(id);
        dto.setPw(pw);
        CustomDTO login = customService.login(dto);
        if (login != null) {
            session.setAttribute("sid", id);
            return "redirect:/";
        } else {
            su.alertAndBackPage(response, "아이디 혹은 비밀번호가 일치하지 않습니다.");
            return "";

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
        String id = request.getParameter("id");
        boolean result = false;
        CustomDTO cusdto = new CustomDTO();
        cusdto = customService.idCheck(id);

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
    public String customJoin(HttpServletRequest request, Model model, CustomDTO cusdto, HttpServletResponse response)
            throws Exception {
        cusdto.setId(request.getParameter("id"));
        cusdto.setPw(request.getParameter("pw"));
        cusdto.setName(request.getParameter("name"));
        cusdto.setEmail(request.getParameter("email"));
        cusdto.setAddress(request.getParameter("address"));
        cusdto.setTel(request.getParameter("tel"));
        CustomDTO join = customService.customJoin(cusdto);
        if (join != null) {
            return "redirect:/";
        } else {
            su.alertAndBackPage(response, "회원가입에 실패했습니다. 다시 시도해주세요. ");
            return "";
        }
    }

    // 마이페이지
    @RequestMapping(value = "mypage.do", method = RequestMethod.GET)
    public String getMypage(CustomDTO dto, Model model, HttpServletResponse response) throws Exception {
        String sid = (String) session.getAttribute("sid");
        CustomDTO mypage = customService.getMypage(sid);
        if (mypage != null) {
            model.addAttribute("mypage", mypage);
            return "custom/mypage";
        } else {
            su.alertAndBackPage(response, "회원님의 정보를 조회할 수 없습니다.");
            return "";
        }
    }

    // 회원탈퇴
    @GetMapping("delete.do")
    public String customdelete(HttpServletResponse response) throws Exception {

        su.alertAndMovePage(response, "탈퇴에 성공하셨습니다.", "/");
        return "redirect:/";
    }
}
