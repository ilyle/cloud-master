package com.xiaoqi.cloudss.feign;

import com.xiaoqi.cloudss.domain.ArticleData;
import com.xiaoqi.cloudss.feign.fallback.WanAndroidFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "WanAndroidFeign", url = "https://www.wanandroid.com", fallback = WanAndroidFeignFallback.class)
public interface WanAndroidFeign {

    @GetMapping("/article/list/{page}/json")
    ArticleData listArticle(@PathVariable(value = "page") int page) throws Exception;
}
