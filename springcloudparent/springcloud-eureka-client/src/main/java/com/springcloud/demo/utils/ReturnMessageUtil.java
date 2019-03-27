package com.springcloud.demo.utils;

import com.springcloud.demo.bean.ReturnMessage;

/**  
 * Description: json 消息处理工具类
 * 					1、成功处理含实体数据
 *				    2、成功处理 没有实体数据
 *					3、失败处理  
 * @author zx  
 * @date 2019年3月26日  
 */
public class ReturnMessageUtil {
	/**
	 * A无异常 请求成功并有具体内容返回
	 * @param object
	 * @return
	 */
	public static ReturnMessage<Object> sucess(Object object) {
		ReturnMessage<Object> message = new ReturnMessage<Object>(1,"sucess",object);
		return message;
	}
	/**
	 * A无异常 请求成功并无具体内容返回
	 * @return
	 */
	public static ReturnMessage<Object> sucess() {
		ReturnMessage<Object> message = new ReturnMessage<Object>(1,"sucess",null);
		return message;
	}
	/**
	 * A有自定义错误异常信息
	 * @param code
	 * @param msg
	 * @return
	 */
	public static ReturnMessage<Object> error(Integer code,String msg) {
		ReturnMessage<Object> message = new ReturnMessage<Object>(code,msg,null);
		return message;
	}

}
