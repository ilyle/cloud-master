package com.xiaoqi.cloudss.service.impl;

import com.xiaoqi.cloudss.constant.WanAndroidUrls;
import com.xiaoqi.cloudss.domain.ArticleData;
import com.xiaoqi.cloudss.feign.WanAndroidFeign;
import com.xiaoqi.cloudss.service.WanAndroidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service(value = "WanAndroidService")
public class WanAndroidServiceImpl implements WanAndroidService{

    @Autowired
    private WanAndroidFeign wanAndroidFeign;

    @Override
    public ArticleData listArticle(int page) throws Exception {
        RestTemplate template = new RestTemplate();
        String url = WanAndroidUrls.articleList + "/{1}/json";
        //ResponseEntity<ArticleData> entity = template.getForEntity(url, ArticleData.class, page);
        //return entity.getBody();
        return wanAndroidFeign.listArticle(page);
    }

    @Override
    public ArticleData queryArticle(int page, String k) {
        RestTemplate template = new RestTemplate();
        String url = WanAndroidUrls.queryArticle + "/{1}/json";
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("k", k);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, new HttpHeaders());
        ResponseEntity<ArticleData> entity = template.postForEntity(url, request, ArticleData.class, page);
        return entity.getBody();
    }
}
