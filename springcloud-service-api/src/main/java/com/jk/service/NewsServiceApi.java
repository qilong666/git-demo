package com.jk.service;

import com.jk.model.NewsBean;
import com.jk.model.NewsType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/2 16:27
 * @Created by ${jmh}
 */
public interface NewsServiceApi {

    @GetMapping("findNewsList/{start}/{pageSize}")
    HashMap<String,Object> findNewsList(@PathVariable(value="start") Integer start,
                                        @PathVariable(value="pageSize") Integer pageSize);

    @GetMapping("queryType")
    List<NewsType> queryType();

    @PostMapping("addNewsTable")
    void addNews(NewsBean news);

    @GetMapping("findBootDialogById/{id}")
    NewsBean findBootDialogById(@PathVariable(value="id")Integer id);

    @PostMapping ("updateNews")
    void updateNews(NewsBean news);



    @DeleteMapping("deleteNews/{id}")
    void deleteNews(@PathVariable(value="id") Integer id);
}
