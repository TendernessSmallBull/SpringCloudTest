package com.springcloud.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.demo.bean.SbException;
import com.springcloud.demo.utils.ReturnMessageUtil;
 
@RestController
@RequestMapping("/error")
public class DemoException {
	
	@GetMapping(value = "custome")
	public void customException() {
		SbException sbe = new SbException(1, "这个是自定义异常！");
		throw sbe;
	}
	@GetMapping(value = "unknown")
	public int unknownException() {
		int i = 0;
		int b = 1/i;
		return b;
	}
	@GetMapping(value = "ok")
	public int noException() {
		int b = 666;
		ReturnMessageUtil.sucess(b);
		return b;
	}
}