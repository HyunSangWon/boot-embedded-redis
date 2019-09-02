package com.example.demo.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
@EnableRedisRepositories
public class RedisRepositoryConfig {
	
	@Value("${spring.redis.host}")
	private String redisHost;
	
	@Value("${spring.redis.port}")
	private int redisPort;
	
	@Bean
    public RedisConnectionFactory redisConnectionFactory() {
		/* java의 Redis Client는 크게 2가지 
		 * Jedis, Lettuce
		 * Lettuce : Netty (비동기 이벤트 기반 고성능 네트워크 프레임워크) 기반의 Redis 클라이언트
		 * Lettuce는 TPS/CPU/Connection 개수/응답속도 등 전 분야에서 우위에 있다.
		 *  */
        return new LettuceConnectionFactory(redisHost, redisPort);//내장 레디스 혹은 설치된 레디스를 연결
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() { //redisConnection에서 넘겨준 값을 객체 직렬화한다.
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return redisTemplate;
    }
}