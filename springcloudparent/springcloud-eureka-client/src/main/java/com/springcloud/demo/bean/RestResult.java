/**  
 * Title: RestResult.java  
 * Description:描述 
 * @author zx  
 * @date 2019年3月26日  
 * @version 1.0  
 */  
package com.springcloud.demo.bean;

/**  
 * Description: 统一返回Rest风格的数据结构
 * @author zx  
 * @date 2019年3月26日  
 */
public class RestResult {
    /**
     * 请求是否成功
     */
    private boolean success;
    /**
     * 成功或者失败的code错误码
     */
    private String code;
    /**
     * 成功时返回的数据，失败时返回具体的异常信息
     */
    private Object data;
    /**
     * 请求失败返回的提示信息，给前端进行页面展示的信息
     */
    private Object errorMessage;
    /**
     * 服务器当前时间（添加该字段的原因是便于查找定位请求时间，因为实际开发过程中服务器时间可能跟本地时间不一致，加上这个时间戳便于日后定位）
     */
    private long currentTime;

    public RestResult() {
    }

    @Override
    public String toString() {
        return "RestResult{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", data=" + data +
                ", errorMessage=" + errorMessage +
                ", currentTime=" + currentTime +
                '}';
    }

    public RestResult(boolean success, String code, Object data, Object errorMessage) {
        this.success = success;
        this.code = code;
        this.data = data;
        this.errorMessage = errorMessage;
        this.currentTime = System.currentTimeMillis();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

	public long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}
    
}
