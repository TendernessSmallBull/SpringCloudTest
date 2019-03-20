/**  
 * Title: FeignTestService.java  
 * Description:描述 
 * @author zx  
 * @date 2019年3月14日  
 * @version 1.0  
 */  
package com.springcloud.demo.inter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**  
 * Description: 描述 
 * @author zx  
 * @date 2019年3月14日  
 */
@FeignClient(value = "service-hi")
public interface FeignTestService {

	@RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
