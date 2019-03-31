package com.springcloud.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Description: 描述 config配置中心客户端
 * @author zx  
 * @date 2019年4月1日
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
    /**
     * http://localhost:xxxx/actuator/bus-refresh
     */
    @Value("${foo}")
    String foo;
    
    @Value("${server.port}")
    String port;
    
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo+",I am from port:" + port;
    }
}
