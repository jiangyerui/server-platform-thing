package com.jyr.iot.thing.config;

import com.jyr.iot.thing.pojogroup.ProjectThing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * 配置redis序列json化存储
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, ProjectThing> deviceRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, ProjectThing> template = new RedisTemplate<Object,ProjectThing>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<ProjectThing> jre = new Jackson2JsonRedisSerializer<ProjectThing>(ProjectThing.class);
        template.setDefaultSerializer(jre);
        return template;
    }
}
