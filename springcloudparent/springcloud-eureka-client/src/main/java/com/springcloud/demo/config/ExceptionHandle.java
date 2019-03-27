package com.springcloud.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springcloud.demo.bean.ReturnMessage;
import com.springcloud.demo.bean.SbException;
import com.springcloud.demo.utils.ReturnMessageUtil;

/**  
 * Description: 异常拦截统统一处理逻辑处理
 * @author zx  
 * @date 2019年3月26日  
 */
@ControllerAdvice
public class ExceptionHandle {
	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ReturnMessage<Object> handle(Exception exception) {
		if(exception instanceof SbException) {
			SbException sbexception = (SbException)exception;
			return ReturnMessageUtil.error(sbexception.getCode(), sbexception.getMessage());
		}else {
			logger.error("系统异常 {}",exception);
			return ReturnMessageUtil.error(-1, "系统异常"+exception);
		}
	}
	
}
