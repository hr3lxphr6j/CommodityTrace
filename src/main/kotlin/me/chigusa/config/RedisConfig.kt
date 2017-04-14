package me.chigusa.config


import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericToStringSerializer
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer


/**
 * @author Chigusa
 * @function Redis配置
 * @date 2017/4/15
 */
@Configuration
@EnableCaching
class RedisConfig {
//    @Bean
//    @SuppressWarnings("rawtypes", "unchecked")
//    fun redisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<Any, Any> {
//        return RedisTemplate<Any, Any>().apply {
//            connectionFactory = redisConnectionFactory
////            keySerializer = GenericToStringSerializer(Any::class.java)
//            valueSerializer = Jackson2JsonRedisSerializer(Any::class.java).apply {
//                setObjectMapper(ObjectMapper().apply {
//                    setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
//                    enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL)
//                })
//            }
//        }
//    }
}