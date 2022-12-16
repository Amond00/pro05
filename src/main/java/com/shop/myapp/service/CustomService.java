package com.shop.myapp.service;

import java.util.List;

import com.shop.myapp.dto.CustomDTO;

public interface CustomService {
    public CustomDTO login(CustomDTO cusdto) throws Exception;

    public List<CustomDTO> customList() throws Exception;

    public CustomDTO idCheck(String cusid) throws Exception;

    public CustomDTO customJoin(CustomDTO cusdto) throws Exception;

}
