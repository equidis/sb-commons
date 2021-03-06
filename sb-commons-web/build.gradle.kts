plugins {
    kotlin("plugin.spring") version "1.4.32"
}

dependencies {
    api(project(":sb-commons-context"))
    api("org.springframework.boot:spring-boot-starter-webflux")
    api("com.fasterxml.jackson.module:jackson-module-kotlin")
    api("org.hibernate.validator:hibernate-validator")
}
