package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/2 16:20
 * @Created by ${jmh}
 */
@FeignClient(value = "springcloud-news-provider" ,fallback = NewsServiceError.class)
public interface NewsServiceFeign extends NewsServiceApi {


}
