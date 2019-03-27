/**  
 * Title: ZuulServerApplication.java  
 * Description:描述 
 * @author zx  
 * @date 2019年3月27日  
 * @version 1.0  
 */  
package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**  
 * Description: 描述 
 * @author zx  
 * @date 2019年3月27日  
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulServerApplication {

	public static void main(String[] args) {
        SpringApplication.run( ZuulServerApplication.class, args );
    }
}
