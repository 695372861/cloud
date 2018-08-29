package com.myredis.redisuse;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizers;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

//@Configuration
//@AutoConfigureAfter(RedisAutoConfiguration.class)
//@ConditionalOnBean(RedisTemplate.class)
//@ConditionalOnMissingBean(CacheManager.class)
//@Conditional(CacheCondition.class)
public class RedisCacheConfiguration {
//    private final CacheProperties cacheProperties;
//
//    private final CacheManagerCustomizers customizerInvoker;
//
//    RedisCacheConfiguration(CacheProperties cacheProperties,
//                            CacheManagerCustomizers customizerInvoker) {
//        this.cacheProperties = cacheProperties;
//        this.customizerInvoker = customizerInvoker;
//    }
//
//    @Bean
//    public RedisCacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
//        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        cacheManager.setUsePrefix(true);
//        List<String> cacheNames = this.cacheProperties.getCacheNames();
//        if (!cacheNames.isEmpty()) {
//            cacheManager.setCacheNames(cacheNames);
//        }
//        return this.customizerInvoker.customize(cacheManager);
//    }
}
