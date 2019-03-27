package com.springcloud.demo.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import net.bytebuddy.asm.Advice.This;

/**  
 * Description: 第一个初始化执行方法
 * @author zx  
 * @date 2019年3月27日  
 */
@Component
@Order(1)
public class StartRunner1 implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(This.class); 
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("在这个方法里可以初始化数据，这里是第一个初始化方法！！！");
	}

}
