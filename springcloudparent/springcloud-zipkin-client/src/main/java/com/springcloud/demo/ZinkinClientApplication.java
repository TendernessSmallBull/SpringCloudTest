package com.springcloud.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * Description: zipkin 测试三条调用关系
 * @author zx  
 * @date 2019年4月2日
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ZinkinClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZinkinClientApplication.class, args);
    }
    
    /**
     * A通过 @Value 获取配置文件中的属性 书写格式 ${server.port}
     */
    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/port", method = RequestMethod.GET)
    public String home(
            @RequestParam(value = "name", defaultValue = "赵大大") String name) {
        return "Hello " + name + " ,I am from zipkin client and my port is:" + port;
    }
}
