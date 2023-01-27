package com.shop.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.myapp.dao.CustomDAO;
import com.shop.myapp.dto.CustomDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomServiceImpl implements CustomService {
    private final CustomDAO customDAO;

    // 로그인
    @Override
    public CustomDTO login(CustomDTO cusdto) throws Exception {
        return customDAO.login(cusdto);
    }

    // 회원정보 리스트
    @Override
    public List<CustomDTO> customList() throws Exception {
        return customDAO.customList();
    }

    // 회원가입
    @Override
    public CustomDTO customJoin(CustomDTO cusdto) throws Exception {
        return customDAO.customJoin(cusdto);
    }

    // 아이디 체크
    @Override
    public CustomDTO idCheck(String cusid) throws Exception {
        return customDAO.idCheck(cusid);
    }

    @Override
    public CustomDTO getMypage(String sid) throws Exception {
        return customDAO.idCheck2(sid);
    }
}
