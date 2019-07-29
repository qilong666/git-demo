package com.jk.service;

import com.jk.mapper.NewsMapper;
import com.jk.model.NewsBean;
import com.jk.model.NewsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/2 16:08
 * @Created by ${jmh}
 */
@Service
public class NewsServiceImpl implements NewsService {



            @Autowired
            private NewsMapper  newsMapper;


    @Override
    public  HashMap<String,Object> findNewsList(Integer page, Integer rows) {


        HashMap<String, Object> hashMap = new HashMap<>();


        Integer  total = newsMapper.findNewsCount();

        List<NewsBean> find  = newsMapper.findNewsList(page,rows);


        hashMap.put("total",total);
        hashMap.put("rows",find);



        return hashMap;
    }

    @Override
    public List<NewsType> queryType() {
        return newsMapper.queryType();
    }

    @Override
    public void addNews(NewsBean news) {
        newsMapper.addNews(news);
    }

    @Override
    public NewsBean findBootDialogById(Integer id) {
        return newsMapper.findBootDialogById(id);
    }

    @Override
    public void updateNews(NewsBean news) {

        newsMapper.updateNews(news);
    }

    @Override
    public void deleteNews(Integer id) {
        newsMapper.deleteNews(id);
    }

    @Override
    public void addId() {

        newsMapper. addId();

        }

    @Override
    public Integer queryMaxId() {
        return newsMapper.queryMaxId();
    }

    @Override
    public void add(String tableName, NewsBean news) {
        newsMapper.add(tableName,news);
    }

    @Override
    public List<NewsBean> getNewsData(Integer newsid) {


        String tableName = "t_news"+newsid % 3;

        return newsMapper.getNewsData(tableName);
    }
}
