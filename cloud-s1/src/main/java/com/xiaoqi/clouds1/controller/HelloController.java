package com.xiaoqi.clouds1.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "Hello接口")
@RestController
@RequestMapping("/hello")
public class HelloController {

    @ApiOperation(value = "Hello World!")
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello S1!";
    }
}
