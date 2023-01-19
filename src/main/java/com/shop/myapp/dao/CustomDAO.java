package com.shop.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.myapp.dto.CustomDTO;

@Mapper
@Repository
public interface CustomDAO {
    public CustomDTO customJoin(CustomDTO cusdto) throws Exception;
    public CustomDTO idCheck(String cusid) throws Exception;
    public CustomDTO login(CustomDTO cusdto) throws Exception;
    public List<CustomDTO> customList() throws Exception;
}
