package com.github.jntakpe.commons.client.test

import org.springframework.cloud.contract.stubrunner.spring.StubRunnerConfiguration
import org.springframework.cloud.contract.stubrunner.spring.cloud.StubRunnerSpringCloudAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(StubRunnerConfiguration::class, StubRunnerSpringCloudAutoConfiguration::class)
class StubRunnerConfiguration
