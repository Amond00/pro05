package com.shop.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.myapp.dto.ResponseDTO;
import com.shop.myapp.dto.SampleDTO;
import com.shop.myapp.service.SampleService;

@Controller
@RequestMapping(value = "/sample/")
public class SampleController {

    @Autowired
    SampleService sampleService;

    //JSON의 ResultCode를 붙여서 보내는 경우
    @ResponseBody
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("S0001");
        responseDTO.setRes(sampleService.findAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    
    @ResponseBody
    @GetMapping("test2")
    public List<SampleDTO> sampleTest() {
        return sampleService.findAll();
    }
    
    
}
