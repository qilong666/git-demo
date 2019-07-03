package com.jk.mapper;

import com.jk.model.NewsBean;
import com.jk.model.NewsType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/2 16:09
 * @Created by ${jmh}
 */
public interface NewsMapper {
    Integer findNewsCount();

    List<NewsBean> findNewsList(@Param("page") Integer page, @Param("rows") Integer rows);

    List<NewsType> queryType();

    void addNews(NewsBean news);

    NewsBean findBootDialogById(Integer id);

    void updateNews(NewsBean news);

    void deleteNews(Integer id);
}
