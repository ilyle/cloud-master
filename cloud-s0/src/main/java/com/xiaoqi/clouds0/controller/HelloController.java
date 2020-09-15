package com.xiaoqi.clouds0.controller;

import com.xiaoqi.common.response.CommHttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "hello s0";
    }
}
