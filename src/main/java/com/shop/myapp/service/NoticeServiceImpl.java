package com.shop.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.myapp.dao.NoticeDAO;
import com.shop.myapp.dto.NoticeDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    private final NoticeDAO noticeDAO;

    @Override
    public List<NoticeDTO> noticeList() {
        return noticeDAO.noticeList();
    }

    @Override
    public NoticeDTO noticeDetail(NoticeDTO notidto) {
        return noticeDAO.noticeDetail(notidto);
    }
}
