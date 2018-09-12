package com.myatomikos.lsxatomikos;

import com.myatomikos.lsxatomikos.datasource.DBConfig1;
import com.myatomikos.lsxatomikos.datasource.DBConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.myatomikos.lsxatomikos","com.myatomikos.lsxatomikos.user1.service","com.myatomikos.lsxatomikos.user2.services"})
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages ={"com.myatomikos.lsxatomikos.user1.dao","com.myatomikos.lsxatomikos.user2.dao"})
@EntityScan("com.myatomikos.lsxatomikos.entity")
@EnableConfigurationProperties(value = {DBConfig1.class, DBConfig2.class })
public class LsxatomikosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LsxatomikosApplication.class, args);
	}
}
