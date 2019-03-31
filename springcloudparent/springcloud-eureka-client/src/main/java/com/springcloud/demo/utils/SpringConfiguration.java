package com.springcloud.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Description: 描述 在Web应用中，Spring容器通常采用声明式方式配置产生：
                                            开发者只要在web.xml中配置一个Listener，该Listener将会负责初始化Spring容器，
                MVC框架可以直接调用Spring容器中的Bean，无需访问Spring容器本身。在这种情况下，
                                            容器中的Bean处于容器管理下，无需主动访问容器，只需接受容器的依赖注入即可。
                                            但在某些特殊的情况下，Bean需要实现某个功能，但该功能必须借助于Spring容器才能实现，
                                            此时就必须让该Bean先获取Spring容器，然后借助于Spring容器实现该功能。
                                            为了让Bean获取它所在的Spring容器，可以让该Bean实现ApplicationContextAware接口。
 * @author zx  
 * @date 2019年3月31日
 */
@Component
public class SpringConfiguration implements ApplicationContextAware{
	
    private static Logger logger = LoggerFactory.getLogger(SpringConfiguration.class);

	
	private static ApplicationContext applicationContext;
	 
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

 
	@SuppressWarnings("static-access")
    @Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		if(this.applicationContext==null){
			this.applicationContext = applicationContext;
			logger.info("===================ApplicationContext对象配置成功=============================");
		}
	}
	/**
	 * Description: 通过name获取 Bean.
	 * @param name
	 * @return
	 */
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }
    /**
     * Description:通过class获取Bean.
     * @param clazz
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }
    /**
     * Description: 通过name,以及Clazz返回指定的Bean
     * @param name
     * @param clazz
     * @return
     */
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
    
    public static void main(String[] args) {
//    	RedisTemplate redisTemplate = SpringConfiguration.getBean(RedisTemplate.class);
	}

}
