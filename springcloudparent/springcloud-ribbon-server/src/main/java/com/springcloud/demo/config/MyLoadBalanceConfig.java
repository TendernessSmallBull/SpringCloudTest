package com.springcloud.demo.config;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**  
 * Description: ribbon配置类可以定制不同的负载规则
 * @author zx  
 * @date 2019年3月22日  
 */
public class MyLoadBalanceConfig {
    @Bean
    public IRule ribbonRule() { 
    	//随机
		return new RandomRule();
        //轮询
//      return new RoundRobinRule();.
        //重试 先按照轮询策略获取服务，如果获取失败则在指定时间内重试，获取可用服务
//      return new RetryRule();
        //选过滤掉多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
//      return new BestAvailableRule();
    	//会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数超过阈值的服务，然后对剩余的服务列表进行轮询
//    	return new AvailabilityFilteringRule();
    	//权重 根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大被选中的概率越高。刚启动时，如果统计信息不足，则使用轮询策略，等信息足够，切换到 WeightedResponseTimeRule
//    	return new WeightedResponseTimeRule();
    	//符合判断server所在区域的性能和server的可用性选择服务
//    	return new ZoneAvoidanceRule();
    	
    }
}
