package com.xiaoqi.cloudss.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cloud-s0", path = "/hello")
public interface HelloFeign {

    @GetMapping("/hello")
    String getHello();
}
