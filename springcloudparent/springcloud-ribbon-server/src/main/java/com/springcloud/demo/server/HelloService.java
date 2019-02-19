 
package com.springcloud.demo.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**  
 * Description: 通过restTemplate方式访问链接
 * @author zx  
 * @date 2019年2月19日  
 */
@Service
public class HelloService {

	@Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://SPRINGCLOUD-EUREKA-CLIENT/hi?name="+name,String.class);
    }

}
