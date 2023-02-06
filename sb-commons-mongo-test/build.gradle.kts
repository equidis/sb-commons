val testContainersVersion: String by project

plugins {
    kotlin("plugin.spring") version "1.8.10"
}

dependencies {
    api(project(":sb-commons-mongo"))
    api(project(":sb-commons-test"))
    api("org.testcontainers:mongodb:$testContainersVersion")
}
