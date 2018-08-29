package com.myredis.redisuse;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class RedisuseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisuseApplication.class, args);
	}


//	@Autowired
//	public void configRedisCacheManger(RedisCacheManager rd)
//	{
//		rd.setDefaultExpiration(100L);
//	}
}
