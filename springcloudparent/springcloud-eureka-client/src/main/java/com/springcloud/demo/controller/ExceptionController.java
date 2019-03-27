package com.springcloud.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.demo.bean.ReturnMessage;
import com.springcloud.demo.bean.SbException;
import com.springcloud.demo.utils.ReturnMessageUtil;
/**
 * Description: 统一错误异常拦截controller测试
 * @author zx  
 * @date 2019年3月27日
 */
@RestController
@RequestMapping("/error")
public class ExceptionController {
	
	@GetMapping(value = "custome")
	public void customException() {
		//自定义异常处理
		throw new SbException("这个是自定义异常！");
	}
	
	@GetMapping(value = "unknown")
	public int unknownException() {
		int i = 0;
		int b = 1/i;
		return b;
	}
	/**
	 * Description: 返回值类型全部为ReturnMessage，使用ReturnMessageUtil进行返回结果封装
	 * @return
	 */
	@GetMapping(value = "ok")
	public ReturnMessage<?> noException() {
		int b = 666;
		return ReturnMessageUtil.sucess(b);
	}
}