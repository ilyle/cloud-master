package com.xiaoqi.cloudss.feign.fallback;

import com.xiaoqi.cloudss.domain.ArticleData;
import com.xiaoqi.cloudss.feign.WanAndroidFeign;
import org.springframework.stereotype.Component;

@Component
public class WanAndroidFeignFallback implements WanAndroidFeign {


    @Override
    public ArticleData listArticle(int page) throws Exception {
        return null;
    }
}
