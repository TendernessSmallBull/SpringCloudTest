 
package com.springcloud.demo.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**  
 * Description: 通过restTemplate方式访问链接
 * @author zx  
 * @date 2019年2月19日  
 */
@Service
public class HelloService {

	@Autowired
    RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "portError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SPRINGCLOUD-EUREKA-CLIENT/port?name="+name,String.class);
    }
	
	@HystrixCommand(fallbackMethod = "portError")
    public String zipkinService(String name) {
        return restTemplate.getForObject("http://SPRINGCLOUD-EUREKA-CLIENT/zipkin?name="+name,String.class);
    }
	
	public String portError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}
