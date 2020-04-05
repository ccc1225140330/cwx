package com.fh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//启动eureka 服务端的功能
@SpringBootApplication
@EnableEurekaServer

public class EurekaStarter {

    public static void main(String[] args) {
        SpringApplication.run(EurekaStarter.class,args);
    }
}
