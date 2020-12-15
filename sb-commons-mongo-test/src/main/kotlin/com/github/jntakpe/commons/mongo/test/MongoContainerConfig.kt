package com.github.jntakpe.commons.mongo.test

import com.github.jntakpe.commons.context.logger
import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MongoContainerConfig {

    private val log = logger()

    @Bean
    fun mongoContainerClient(settings: MongoClientSettings): MongoClient {
        val container = MongoContainer.instance
        val mongoUri = "mongodb://${container.containerIpAddress}:${container.firstMappedPort}"
        log.debug("Setting Mongo container URI to $mongoUri")
        val containerSettings = MongoClientSettings.builder(settings)
            .applyConnectionString(ConnectionString(mongoUri)).build()
        return MongoClients.create(containerSettings)
    }
}
