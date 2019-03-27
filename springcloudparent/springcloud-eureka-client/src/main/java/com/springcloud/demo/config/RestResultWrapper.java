package com.springcloud.demo.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.alibaba.fastjson.JSONObject;
import com.springcloud.demo.bean.RestResult;

/**  
 * Description: 可拦截所有controller 返回值，对返回值进行包装 （这里有问题实现ResponseBodyAdvice后swagger页面报错）
 * @author zx  
 * @date 2019年3月26日
 * @ControllerAdvice  
 */
public class RestResultWrapper implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        RestResult result = new RestResult(true, "0", body, null);
        return JSONObject.toJSON(result);
    }
}
