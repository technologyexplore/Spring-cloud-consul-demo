package com.shein.springcloudconsulconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableHystrixDashboard
//@EnableTurbine
@EnableHystrix
public class SpringCloudConsulConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConsulConsumerApplication.class, args);
	}

}
