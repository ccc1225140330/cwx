package com.fh.api;

import com.fh.entity.Employee;
import com.fh.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="provider",fallbackFactory=MyFallBackFactory.class)
//指定要调用的微服务的名称  接口信息要和  provider 那端的保持一致才行
//传值的话 @RequestParam @RequestBody @PathVariable 注解 不能省略
public interface Service {
    @RequestMapping("/sss/sss")
    public Employee getE(@RequestParam("key") String key);


    @RequestMapping("/hystrix/lizi")
    public ResultEntity<Employee> getEmployee(@RequestParam("key") String key);
}
