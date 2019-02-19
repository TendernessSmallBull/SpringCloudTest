package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**  
 * Description: eureka服务端启动类
 * 				@EnableEurekaServer 注释表名此服务为注册中心的服务端端程序
 * @author zx  
 * @date 2019年2月18日  
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
        SpringApplication.run( EurekaServerApplication.class, args );
    }
}
