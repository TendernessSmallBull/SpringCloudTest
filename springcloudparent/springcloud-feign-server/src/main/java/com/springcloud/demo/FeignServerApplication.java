package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**  
 * Description: 描述 
 * @author zx  
 * @date 2019年3月14日  
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignServerApplication {
	public static void main(String[] args) {
        SpringApplication.run( FeignServerApplication.class, args );
    }
}
