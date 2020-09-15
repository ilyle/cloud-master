package com.xiaoqi.cloudss.service.impl;

import com.xiaoqi.cloudss.feign.HelloFeign;
import com.xiaoqi.cloudss.service.HelloService;
import com.xiaoqi.common.response.CommHttpResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "helloService")
public class HelloServiceImpl implements HelloService {

    @Resource
    private HelloFeign helloFeign;

    @Override
    public String helloFeign() {
        return helloFeign.getHello();
    }
}
