package com.fh.controller;

import com.fh.api.Service;
import com.fh.entity.Employee;
import com.fh.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/consumer/ribbon/get/employee")
    public Employee getEmployeeRemote() {
        // 远程调用方法的主机地址
       // String host = "http://localhost:1000";
        //使用eureka调用  使用的是 注册的微服务的名称
        String host = "http://provide";
        // 远程调用方法的具体 URL 地址
        String url = "/provider/get/employee/remote";
        return restTemplate.getForObject(host + url, Employee.class);
    }


    @Autowired
    private Service service;
    @RequestMapping("/aa/aa")
    public Employee getEe(String key){
        key = "222";
        Employee e = service.getE(key);
        return e;
    }
    //熔断实验
    @RequestMapping("/aaa/aa")
    public String get(){
        ResultEntity<Employee> ss = service.getEmployee("哈哈");
        String message = ss.getMessage();
        return message;
    }

}
