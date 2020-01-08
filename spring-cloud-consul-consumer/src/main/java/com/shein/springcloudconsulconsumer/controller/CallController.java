package com.shein.springcloudconsulconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author zhangchuan
 * @Date 2019/11/18 - 20:31
 * @Version 1.0
 */
@RestController
public class CallController {

	@Autowired
	private LoadBalancerClient loadBalancer;

	@RequestMapping("/call")
	public String call() {
		ServiceInstance serviceInstance = loadBalancer.choose("service-producer4");
		System.out.println("服务地址：" + serviceInstance.getUri());
		System.out.println("服务名称：" + serviceInstance.getServiceId());

		String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/hello", String.class);
		System.out.println(callServiceResult);
		return callServiceResult;
	}

}
