package com.jk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/5 17:00
 * @Created by ${jmh}
 */
@RestController
public class NewController {



     @Autowired
     private RestTemplate restTemplate;

    @GetMapping("hello")
    public  String hello(){

        String uri = "http://springcloud-news-provider/hello";

        String forObject = restTemplate.getForObject(uri, String.class);

        return forObject;

    }








}
