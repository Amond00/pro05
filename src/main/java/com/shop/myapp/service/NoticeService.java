package com.shop.myapp.service;

import java.util.List;

import com.shop.myapp.dto.NoticeDTO;

public interface NoticeService {
    public List<NoticeDTO> noticeList();

    public NoticeDTO noticeDetail(NoticeDTO notidto);
}
