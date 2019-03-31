package com.springcloud.demo.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
/**
 * Description: zuul filter 
 * @author zx  
 * @date 2019年3月31日
 */
@Component
public class AllOfUrlFilter extends ZuulFilter{
    
    private static Logger log = LoggerFactory.getLogger(AllOfUrlFilter.class);
    /**
     * A这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /**
     * A过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     * A这里声明一下zuul过滤器执行网络请求发生的异常，过滤器里面是不能直接将try-catch捕捉的异常抛出给页面的。
     * A应用程序抛出的异常是可以返回出的需解决办法就是在catch里面用context.set()方法返回给页面。
     */
    @Override
    public Object run() throws ZuulException {
        try {
            //业务逻辑
        }
        catch (Exception e) {
            RequestContext context = RequestContext.getCurrentContext();
            context.set("error.status_code",401);
            context.set("error.exception",e);
            context.set("error.message","sfdfsdf");
        }
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){
                
            }
            return null;
        }
        log.info("ok");
        return null;
    }
    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }
    /**
     * A过滤的顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

}
