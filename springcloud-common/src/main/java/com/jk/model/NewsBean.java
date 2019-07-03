package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/1 18:00
 * @Created by ${jmh}
 */
public class NewsBean implements Serializable {



          private   Integer  newId;


          private    String  title;

          private    String   content;

          @DateTimeFormat(pattern = "yyyy-MM-dd")
          @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
          private     Date    publishDate;

          private     String   author;

          private     Integer  typeId;


          private     String   typeName;

    public Integer getNewId() {
        return newId;
    }

    public void setNewId(Integer newId) {
        this.newId = newId;
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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
