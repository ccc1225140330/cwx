package com.fh.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringCloudConf {

    @Bean
    @LoadBalanced
    //上面这个注解 让 consummer加入了ribbon 拥有了负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
