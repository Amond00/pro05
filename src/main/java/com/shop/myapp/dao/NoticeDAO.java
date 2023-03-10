package com.shop.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.myapp.dto.NoticeDTO;

@Mapper
@Repository
public interface NoticeDAO {
    List<NoticeDTO> noticeList();

    NoticeDTO noticeDetail(NoticeDTO dto);
}
