package com.fh.api;

import com.fh.entity.Employee;
import com.fh.util.ResultEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFallBackFactory implements FallbackFactory<Service> {

    @Override
    public Service create(Throwable throwable) {
        return new Service() {

            @Override
            public Employee getE(String key) {
                return new Employee(222,"降级",22.2);
            }

            @Override
            public ResultEntity<Employee> getEmployee(String key) {
                return ResultEntity.failed("降级了");
            }
        };
    }
}
