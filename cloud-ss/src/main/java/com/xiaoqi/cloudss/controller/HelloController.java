package com.xiaoqi.cloudss.controller;

import com.xiaoqi.cloudss.service.HelloService;
import com.xiaoqi.common.response.CommHttpResponse;
import com.xiaoqi.common.response.CommHttpResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "Hello接口")
@RestController
@RequestMapping("/hello")
public class HelloController extends BaseController{

    @Autowired
    private HelloService helloService;

    @ApiOperation(value = "Hello World!")
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello S1!";
    }

    @GetMapping(value = "helloFeign")
    public CommHttpResponse<String> helloFeign() {
        return CommHttpResponseUtil.success(helloService.helloFeign());
    }
}
