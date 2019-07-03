package com.jk.repository;

import com.jk.pojo.ElasticBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/3 21:13
 * @Created by ${jmh}
 */
public interface NewsRepository extends ElasticsearchCrudRepository<ElasticBean,Integer> {



}
