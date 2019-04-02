package com.springcloud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.demo.service.FeignTestService;

/**  
 * Description: 测试controller
 * @author zx  
 * @date 2019年3月14日  
 */
@RestController
public class FeignTestController {

	@Autowired
	FeignTestService feignTestService;
	
	@GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return feignTestService.sayHiFromClientOne( name );
    }

}
