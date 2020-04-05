package com.fh.controller;

import com.fh.entity.Employee;
import com.fh.util.ResultEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EmployeeController {

    //关于feign的远程调用
    @RequestMapping("/sss/sss")
    public Employee getE(@RequestParam("key")String key){
        System.out.println(key);
       return new Employee(111,"222",222.22);
    }

    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote(HttpServletRequest request) {
        //获取端口号
        int serverPort = request.getServerPort();
        return new Employee(555, "tom555+port:"+serverPort, 555.55);
    }

    //熔断使用
    //注解的作用是 方法调用失败时 默认调用的方法 getEmployeeUp
    @HystrixCommand(fallbackMethod="getEmployeeUp")
    @RequestMapping("/hystrix/lizi")
    public ResultEntity<Employee> getEmployee(@RequestParam("key") String key){
        if(key.equals("哈哈")){
            throw new RuntimeException();
        }
        return ResultEntity.successWithData(new Employee(22,"222",22.22));
    }

    public ResultEntity<Employee> getEmployeeUp(@RequestParam("key") String key){
        return ResultEntity.failed("失败了");
    }

}
