package com.github.jntakpe.commons.web.test

import com.github.jntakpe.commons.test.TestInitializer
import io.restassured.module.webtestclient.RestAssuredWebTestClient
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.ObjectProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cache.CacheManager
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
@AutoConfigureWebTestClient
abstract class ContractBaseClass {

    @Autowired private lateinit var client: WebTestClient
    @Autowired private lateinit var testInitializers: ObjectProvider<TestInitializer<*>>
    @Autowired private lateinit var cacheManager: ObjectProvider<CacheManager>

    @BeforeEach
    fun beforeEach() {
        RestAssuredWebTestClient.webTestClient(client)
        testInitializers.forEach { it.init() }
        cacheManager.ifAvailable?.run { cacheNames.mapNotNull { getCache(it) }.forEach { it.clear() } }
    }

    @AfterEach
    fun afterEach() {
        testInitializers.forEach { it.clean() }
    }
}
