package com.xiaoqi.cloudss.service;

import com.xiaoqi.cloudss.domain.ArticleData;

public interface WanAndroidService {

    public ArticleData listArticle(int page) throws Exception;

    public ArticleData queryArticle(int page, String k) throws Exception;

}
