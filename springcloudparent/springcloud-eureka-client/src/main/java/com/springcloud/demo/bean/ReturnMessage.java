package com.springcloud.demo.bean;

/**
 * Description: restfull 请求返回json 信息实体类
 * @author zx
 * @date 2019年3月26日
 */
public class ReturnMessage<T> {
	/**
	 * A错误码
	 */
	private Integer code;
	/**
	 * A提示信息
	 */
	private String message;
	/**
	 * A返回具体内容
	 */
	private T date;

	public ReturnMessage(Integer code, String message, T date) {
		super();
		this.code = code;
		this.message = message;
		this.date = date;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public T getDate() {
		return date;
	}
	
	public void setDate(T date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ReturnMessage [code=" + code + ", message=" + message
				+ ", date=" + date + "]";
	}

}