package com.springcloud.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springcloud.demo.bean.SwaggerConfigration;
/**
 * Description: 测试类测试
 * @author zx  
 * @date 2019年3月24日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EurekaClientApplication.class)
public class SwaggerConfigrationTest {

    @Autowired
    private SwaggerConfigration swaggerConfigration;


    @Test
    public void getHello() throws Exception {
        Assert.assertEquals(swaggerConfigration.getDescription(), "Spring Boot中使用Swagger2构建RESTful APIs");
        Assert.assertEquals(swaggerConfigration.getScanPackage(), "com.springcloud.demo.controller");
    }
}
