package com.jk.service;

import com.jk.model.NewsBean;
import com.jk.model.NewsType;

import java.util.HashMap;
import java.util.List;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/2 16:08
 * @Created by ${jmh}
 */
public interface NewsService {
    HashMap<String,Object> findNewsList(Integer page, Integer rows);

    List<NewsType> queryType();

    void addNews(NewsBean news);

    NewsBean findBootDialogById(Integer id);

    void updateNews(NewsBean news);

    void deleteNews(Integer id);

    void addId();

    Integer queryMaxId();

    void add(String tableName, NewsBean news);

    List<NewsBean> getNewsData(Integer newsid);
}
