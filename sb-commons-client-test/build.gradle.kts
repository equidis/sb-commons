plugins {
    kotlin("plugin.spring") version "1.6.21"
}

dependencies {
    api(project(":sb-commons-test"))
    api("org.springframework.cloud:spring-cloud-starter-contract-stub-runner")
    api("org.springframework.cloud:spring-cloud-contract-wiremock")
}
