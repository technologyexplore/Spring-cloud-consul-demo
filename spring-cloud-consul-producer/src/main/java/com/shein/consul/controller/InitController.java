package com.shein.consul.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author zhangchuan
 * @Date 2019/11/18 - 18:45
 * @Version 1.0
 */
@RestController
public class InitController {

	@RequestMapping("/hello")
	public String sayHello(){
		return "我是服务提供者";
	}



}
