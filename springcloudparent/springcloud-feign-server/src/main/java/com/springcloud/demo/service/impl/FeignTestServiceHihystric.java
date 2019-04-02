package com.springcloud.demo.service.impl;

import org.springframework.stereotype.Component;

import com.springcloud.demo.service.FeignTestService;
/**
 * Description: feign 发生熔断后所走方法
 * @author zx  
 * @date 2019年4月2日
 */
@Component
public class FeignTestServiceHihystric implements FeignTestService{

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name+"已发生feign熔断！";
    }

}
