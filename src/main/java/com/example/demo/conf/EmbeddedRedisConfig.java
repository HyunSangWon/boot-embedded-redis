package com.example.demo.conf;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.extern.slf4j.Slf4j;
import redis.embedded.RedisServer;

@Slf4j
@Profile("dev") //profile이 dev일때만 활성화 
@Configuration
public class EmbeddedRedisConfig {

	@Value("${spring.redis.port}")
    private int redisPort;
	
	private RedisServer redisServer;
	
	@PostConstruct
	public void redisServer() throws IOException{
		 redisServer = new RedisServer(redisPort);
         redisServer.start();
	}
	
	@PreDestroy
	public void stopRedis() {
		if(redisServer != null) redisServer.stop();
	}
	
}
