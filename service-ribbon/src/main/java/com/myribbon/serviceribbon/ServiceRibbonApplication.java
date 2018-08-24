package com.myribbon.serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix//添加这个注解开启Hystrix熔断器
//spring cloud中discovery service有许多种实现（eureka、consul、zookeeper等等），
// @EnableDiscoveryClient基于spring-cloud-commons,
// @EnableEurekaClient基于spring-cloud-netflix。
// 就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，
// 如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。
public class ServiceRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
