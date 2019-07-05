package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient

public class SpringcloudRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudRibbonApplication.class, args);
    }

    // 将RestTemplate注入到spring容器中
    // LoadBalanced负载均衡默认为轮询
    // 通过注入在controller中就可以使用调用生产者实例
    @Bean
    @LoadBalanced
    RestTemplate  restTemplate(){
        return new RestTemplate();
    };

}
