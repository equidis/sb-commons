plugins {
    kotlin("plugin.spring") version "1.8.0"
}

dependencies {
    api(project(":sb-commons-test"))
    api("org.springframework.cloud:spring-cloud-starter-contract-stub-runner")
    api("org.springframework.cloud:spring-cloud-contract-wiremock")
}
