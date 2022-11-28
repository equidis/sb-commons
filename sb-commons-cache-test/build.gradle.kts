val junitVersion: String by project
val mockkVersion: String by project
val assertJVersion: String by project
val testContainersVersion: String by project

plugins {
    kotlin("plugin.spring") version "1.7.22"
}

dependencies {
    api(project(":sb-commons-cache"))
    api(project(":sb-commons-test"))
}
