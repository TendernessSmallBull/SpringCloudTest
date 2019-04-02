package com.springcloud.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springcloud.demo.service.impl.FeignTestServiceHihystric;

/**  
 * Description: 描述 
 * @author zx  
 * @date 2019年3月14日  
 */
@FeignClient(value = "springcloud-eureka-client",fallback = FeignTestServiceHihystric.class)
public interface FeignTestService {
	
    /**
     * Description: feign测试调用方法
     * @param name
     * @return
     */
	@RequestMapping(value = "/port",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
