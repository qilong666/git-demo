package com.jk.model;

import java.io.Serializable;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/1 19:31
 * @Created by ${jmh}
 */
public class NewsType implements Serializable {



         private   Integer  typeId;

         private   String   typeName;


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
