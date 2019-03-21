package com.springcloud.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**  
 * Description: 用于swagger2和restful的controller的测试类
 * @author zx  
 * @date 2019年3月21日  
 */

@RestController
@RequestMapping(value="/users")   
@Api(value = "一个用来测试swagger注解的控制器")
public class UserController {

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String getUser(@PathVariable String id) {
        return "传入参数为："+id;
    }
    
    @RequestMapping(value="/test/{hhh}", method=RequestMethod.GET)
    @ApiOperation(notes = "测试Swagger", value = "test")
    @ApiImplicitParam(name = "hhh", value = "用户ID", required = true, dataType = "String")
    public String Test( @PathVariable("hhh") String hhh ) {
       return hhh;
    }

    @RequestMapping(value ="/getUserName", method= RequestMethod.GET)
    @ApiOperation(value="根据用户编号获取用户姓名", notes="test: 仅1和2有正确返回")
    @ApiImplicitParam(paramType="query", name = "userNumber", value = "用户编号", required = true, dataType = "Integer")
    public String getUserName(@RequestParam Integer userNumber){
        if(userNumber == 1){
            return "张三丰";
        }
        else if(userNumber == 2){
            return "慕容复";
        }
        else{
            return "未知";
        }
    }


}