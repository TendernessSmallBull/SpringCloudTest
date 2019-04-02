package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.springcloud.demo.config.MyLoadBalanceConfig;

/**  
 * Description: @EnableDiscoveryClient spring cloud中discovery service有许多种实现
    *   （eureka、consul、zookeeper等等），@EnableDiscoveryClient基于spring-cloud-commons, 
 * @EnableEurekaClient基于spring-cloud-netflix。其实用更简单的话来说，就是如果选用的注册中心是eureka，
    *    那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。
    *    注解@EnableEurekaClient上有@EnableDiscoveryClient注解，
    *    可以说基本就是EnableEurekaClient有@EnableDiscoveryClient的功能，
    *    另外上面的注释中提到，其实@EnableEurekaClientz注解就是一种方便使用eureka的注解而已，
    *    可以说使用其他的注册中心后，都可以使用@EnableDiscoveryClient注解，
    *    但是使用@EnableEurekaClient的情景，就是在服务采用eureka作为注册中心的时候，使用场景较为单一。
 * @author zx  
 * @date 2019年2月19日  
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name="ribbonClient",configuration=MyLoadBalanceConfig.class)
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class RibbonServerApplication {

	public static void main(String[] args) {
        SpringApplication.run( RibbonServerApplication.class, args );
    }
	/**
	 * @LoadBalanced 添加负载均衡
	 * Description: 描述 
	 * @return
	 */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
