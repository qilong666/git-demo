package com.jk.controller;

import com.jk.model.NewsBean;
import com.jk.model.NewsType;
import com.jk.service.NewsServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/2 16:19
 * @Created by ${jmh}
 */
@RestController
public class NewsController {

      @Autowired
      private NewsServiceFeign  newsServiceFeign;


    @RequestMapping("toList")
    public ModelAndView  toList(ModelAndView mv){
        mv.setViewName("Bootstarp");
        return mv;
    }

    @RequestMapping("toShow")
    public  ModelAndView  toShow(ModelAndView mv){
        mv.setViewName("newsShow");
        return mv;

    }


     @GetMapping("findNewsList")
     public HashMap<String,Object> findNewsList(@RequestParam Integer start, @RequestParam Integer pageSize){
         return  newsServiceFeign.findNewsList(start,pageSize);
     }

     @GetMapping("queryType")
     public  List<NewsType> queryType(){
        return newsServiceFeign.queryType();
     }

     @PostMapping("addNews")
     public  ModelAndView  addNews(ModelAndView mv){
        mv.setViewName("addNews");
        return mv;

     }

     @PostMapping("addNewsTable")
     public  void  addNewsTable (NewsBean news){

         newsServiceFeign.addNews(news);
     }


     @PostMapping("findBootDialogById")
     public  ModelAndView  findBootDialogById(@RequestParam Integer id,ModelAndView mv){

         NewsBean  news  = newsServiceFeign.findBootDialogById(id);

         mv.addObject("news",news);

         mv.setViewName("updateNews");

         return mv;

     }

   // updateNews
     @PostMapping ("updateNews")
     public  void  updateNews ( NewsBean news){
         newsServiceFeign.updateNews(news);
     }

     @RequestMapping(value = "deleteNews",method = RequestMethod.DELETE)
      public  void  deleteNews(@RequestParam Integer id){

         newsServiceFeign.deleteNews(id);

     }









}
