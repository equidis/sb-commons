dependencies {
    api(project(":commons-context"))
    api("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    compileOnly("org.springframework.boot:spring-boot-starter-webflux")
}
