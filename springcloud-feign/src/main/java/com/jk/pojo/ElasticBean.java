package com.jk.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/3 21:00
 * @Created by ${jmh}
 */

@Document(indexName = "news2",type = "newsInfo2")
public class ElasticBean implements Serializable {

    private static final long serialVersionUID = 234776198795365558L;
             @Id
             private  Integer  newid;

             private  String   title;

             private  String   content;


            @DateTimeFormat(pattern = "yyyy-MM-dd")
            @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
             private    Date   publishdate;

             private    String  author;

             private    Integer  typeid;

             private    String   typename;


    public Integer getNewid() {
        return newid;
    }

    public void setNewid(Integer newid) {
        this.newid = newid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}
