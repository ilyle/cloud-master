package com.xiaoqi.cloudss.controller;

import com.xiaoqi.cloudss.domain.ArticleData;
import com.xiaoqi.cloudss.service.WanAndroidService;
import com.xiaoqi.common.response.CommHttpResponse;
import com.xiaoqi.common.response.CommHttpResponseUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "Wanandroid接口")
@RequestMapping("/wanandroid")
@Slf4j
public class WanAndroidController extends BaseController {

    @Autowired
    private WanAndroidService wanAndroidService;

    @RequestMapping(value = "article/list", method = RequestMethod.GET)
    public CommHttpResponse<ArticleData> listArticle(@RequestParam("page") int page) {
        log.info("罗列玩安卓文章列表：{}", page);
        try {
            ArticleData articleData = wanAndroidService.listArticle(page);
            log.info(articleData.toString());
            return CommHttpResponseUtil.success(articleData);
        } catch (Exception e) {
            log.error(e.getMessage());
            return CommHttpResponseUtil.error(e.getMessage());
        }
    }

    @RequestMapping(value = "article/query", method = RequestMethod.POST)
    public CommHttpResponse<ArticleData> queryArticle(@RequestParam("page") int page, @RequestParam("k") String k) {
        log.info("查询玩安卓文章列表：{}{}", page, k);
        try {
            ArticleData articleData = wanAndroidService.queryArticle(page, k);
            log.info(articleData.toString());
            return CommHttpResponseUtil.success(articleData);
        } catch (Exception e) {
            log.error(e.getMessage());
            return CommHttpResponseUtil.error(e.getMessage());
        }
    }
}
