package com.github.jntakpe.commons.cache.test

import com.github.jntakpe.commons.context.logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory

@Configuration
class RedisContainerConfig {

    private val log = logger()

    @Bean
    fun lettuceConnectionFactory(): LettuceConnectionFactory {
        val container = RedisContainer.instance
        val hostName = container.containerIpAddress
        val port = container.firstMappedPort
        log.debug("Setting Redis address container URI to $hostName:$port")
        return LettuceConnectionFactory(RedisStandaloneConfiguration(hostName, port))
    }
}
