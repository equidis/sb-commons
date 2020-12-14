val junitVersion: String by project
val mockkVersion: String by project
val assertJVersion: String by project
val testContainersVersion: String by project

dependencies {
    api(project(":sb-commons-context"))
    api(platform("org.junit:junit-bom:$junitVersion"))
    api("org.junit.jupiter:junit-jupiter-params")
    api("org.springframework.boot:spring-boot-starter-test")
    api("io.mockk:mockk:$mockkVersion")
    api("io.projectreactor:reactor-test")
    api("org.assertj:assertj-core:$assertJVersion")
    api("org.testcontainers:testcontainers:$testContainersVersion")
    api("org.testcontainers:junit-jupiter:$testContainersVersion")
    compileOnly("org.springframework.boot:spring-boot-starter-webflux")
}
