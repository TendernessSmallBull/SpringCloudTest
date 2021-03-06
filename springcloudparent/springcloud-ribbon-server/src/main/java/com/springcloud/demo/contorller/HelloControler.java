package com.springcloud.demo.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.demo.server.HelloService;

/**  
 * Description: ribbon 访问测试链接
 * @author zx  
 * @date 2019年2月19日  
 */
@RestController
public class HelloControler {
	/**
	 * @Autowired 自动注入
	 */
	@Autowired
    HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService( name );
    }
    
    @GetMapping(value = "/zipkin")
    public String zipkin(@RequestParam String name) {
        return helloService.zipkinService(name);
    }

}
