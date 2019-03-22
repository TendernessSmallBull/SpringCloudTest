package com.springcloud.demo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.demo.bean.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**  
 * Description: 用于swagger2和restful的controller的测试类
 * @author zx  
 * @date 2019年3月21日  
 */
@RestController
@RequestMapping(value="/users")   
public class UserController {
	
	/**
	 * Description: 参数在链接上 
	 * @param id
	 * @return
	 */
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String")
    public String getUser(@PathVariable String id) {
        return "传入参数为："+id;
    }
    /**
     * Description: 参数为不同类型（非String） 注意这里不可以为integer包装类
     * @param userNumber
     * @return
     */
    @RequestMapping(value ="/getUserName", method= RequestMethod.GET)
    @ApiOperation(value="根据用户编号获取用户姓名", notes="test: 仅1和2有正确返回")
    @ApiImplicitParam(name = "userNumber", value = "用户编号", required = true, dataType = "int")
    public String getUserName(@RequestParam int userNumber){
    	int a = 1;
    	int b = 2;
        if(userNumber == a ){
            return "张三丰";
        } else if(userNumber == b){
            return "慕容复";
        } else{
            return "未知";
        }
    }
    /**
     * Description: 参数在链接后？拼接  
     * @param userId
     * @param password
     * @param newPassword
     * @return
     */
    @GetMapping("/updatePassword")
    @ApiOperation(value="修改用户密码", notes="根据用户id修改密码")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String"),
        @ApiImplicitParam(name = "password", value = "旧密码", required = true, dataType = "String"),
        @ApiImplicitParam(name = "newPassword", value = "新密码", required = true, dataType = "String")
    })
    public String updatePassword( String userId, String password, String newPassword){
    	System.out.println("+++++"+userId+"++++++"+password+"+++++"+newPassword);
      if(StringUtils.isEmpty(password) || StringUtils.isEmpty(newPassword)){
          return "密码不能为空";
      }
      if(password.equals(newPassword)){
          return "新旧密码不能相同";
      }
      return "密码修改成功!";
    }
    
    @PostMapping("/user")
    @ApiOperation(value="传入对象测试", notes="传入user对象")
    @ApiImplicitParam(name = "user", value = "user对象", required = true, dataType = "User")
    public User getUser(User user) {
    	System.out.println(user);
		return user;
    }
    
    @DeleteMapping("/user")
    @ApiOperation(value="传入对象测试", notes="传入user对象")
    @ApiImplicitParam(name = "user", value = "user对象", required = true, dataType = "User")
    public User deleteUser(User user) {
    	System.out.println(user);
		return user;
    }
    
    @PutMapping("/user")
    @ApiOperation(value="传入对象测试", notes="传入user对象")
    @ApiImplicitParam(name = "user", value = "user对象", required = true, dataType = "User")
    public User updateUser(User user) {
    	System.out.println(user);
		return user;
    }

}