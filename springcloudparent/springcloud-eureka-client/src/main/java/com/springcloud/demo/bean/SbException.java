package com.springcloud.demo.bean;

/**  
 * Description: 自定义异常
 * @author zx  
 * @date 2019年3月26日  
 */
public class SbException extends RuntimeException{

	private static final long serialVersionUID = -8201518085425482189L;
	 
	private Integer code = -1;
	
	public SbException(String message) {
		super(message);
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}

}
