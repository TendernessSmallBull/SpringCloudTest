package com.springcloud.demo.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import net.bytebuddy.asm.Advice.This;

/**  
 * Description: 另一种启动加载方法
 * @author zx  
 * @date 2019年3月27日  
 */
@Configuration
public class StartRunnerOther implements ApplicationRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(This.class); 

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("在这个方法里可以初始化数据，这里是另一种初始化方法！！！");
	}

	
}
