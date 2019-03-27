package com.springcloud.demo.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
 * Description: 拦截所有客户端访问错误，并给出友好提示 （只有404，后续添加其他类型页面）
 * @author zx  
 * @date 2019年3月27日  
 */
@Controller
@RequestMapping("/error")
public class BaseErrorPage implements ErrorController {
 
    Logger logger = LoggerFactory.getLogger(BaseErrorPage.class);
 
    @Override
    public String getErrorPath() {
        return "error";
    }
 
    @RequestMapping
    public String error(HttpServletRequest request) {
    	Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == 404){
        	logger.info("======找不到页面，进入错误提示页面======");
            return "/404";
        }else{
        	logger.info("======服务器错误======");
            return "/500";
        }
    }
}