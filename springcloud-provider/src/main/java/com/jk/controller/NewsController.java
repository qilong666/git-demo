package com.jk.controller;

import com.jk.model.NewsBean;
import com.jk.model.NewsType;
import com.jk.service.NewsService;
import com.jk.service.NewsServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/2 16:08
 * @Created by ${jmh}
 */
@RestController
public class NewsController implements NewsServiceApi {


          @Autowired
          private NewsService newsService;


    @Override
    @GetMapping("findNewsList/{start}/{pageSize}")
    public HashMap<String,Object> findNewsList(@PathVariable(value="start") Integer start,
                                               @PathVariable(value="pageSize") Integer pageSize) {
        return newsService.findNewsList(start,pageSize);
    }

    @Override
    @GetMapping("queryType")
    public List<NewsType> queryType() {
        return newsService.queryType();
    }

    @Override
    @PostMapping("addNewsTable")
    public void addNews(@RequestBody NewsBean news) {
       /* newsService.addNews(news);*/

        newsService.addId();

        Integer  keyId = newsService.queryMaxId();

        news.setNewId(keyId);

        String  tableName = "t_news" + keyId % 3;


        newsService.add(tableName,news);
    }

    @Override
    @GetMapping("findBootDialogById/{id}")
    public NewsBean findBootDialogById(@PathVariable(value = "id") Integer id) {
        return newsService.findBootDialogById(id);
    }

    @Override
    @PostMapping ("updateNews")
    public void updateNews(@RequestBody NewsBean news) {
        newsService.updateNews(news);
    }

    @Override
    @DeleteMapping("deleteNews/{id}")
    public void deleteNews(@PathVariable(value = "id") Integer id) {
        newsService.deleteNews(id);
    }

    @Override
    @GetMapping("hello")
    public String hello(){
        return "我是董事长，爱好赚钱！！！，今年18岁";
    }

    @GetMapping("getNewsData")
    public  List<NewsBean>  getNewsData(@RequestParam(value = "newsid") Integer newsid){
      List<NewsBean>  newlist = newsService.getNewsData(newsid);
      return  newlist;
    }





}
