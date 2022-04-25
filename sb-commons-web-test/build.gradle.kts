plugins {
    kotlin("plugin.spring") version "1.6.21"
}

dependencies {
    api(project(":sb-commons-test"))
    api(project(":sb-commons-web"))
    api("org.springframework.cloud:spring-cloud-starter-contract-verifier")
    api("io.rest-assured:spring-web-test-client")
}
