/**  
 * Title: htmlController.java  
 * Description:描述 
 * @author zx  
 * @date 2019年3月25日  
 * @version 1.0  
 */  
package com.springcloud.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**  
 * Description: 用来访问静态页面
 * @author zx  
 * @date 2019年3月25日  
 */
@Controller
public class htmlController {
	
	@GetMapping("/index")
	public String htmlString() {
		return "index";
	}
	@GetMapping("/NewFile")
	public String html1String() {
		return "NewFile";
	}
}
