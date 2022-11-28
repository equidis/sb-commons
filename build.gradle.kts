import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion: String by project
val springBootVersion: String by project
val springCloudVersion: String by project

plugins {
    idea
    `java-library`
    `maven-publish`
    kotlin("jvm") version "1.7.22"
}

allprojects {
    apply(plugin = "idea")
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")
    apply(plugin = "kotlin")

    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
    }
}

subprojects {
    group = "com.github.jntakpe"
    version = "0.1.2"

    dependencies {
        api(enforcedPlatform("org.springframework.boot:spring-boot-dependencies:$springBootVersion"))
        api(enforcedPlatform("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion"))
        api("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
        api("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_11
        withJavadocJar()
        withSourcesJar()
    }

    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = "11"
                javaParameters = true
            }
        }
    }

    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                from(components.findByName("java"))
                pom {
                    name.set(project.name)
                    description.set("Spring Boot common's library")
                    url.set("https://github.com/equidis/sb-commons")
                    licenses {
                        license {
                            name.set("MIT License")
                            url.set("https://opensource.org/licenses/MIT")
                        }
                    }
                    developers {
                        developer {
                            id.set("jntakpe")
                            name.set("Jocelyn NTAKPE")
                        }
                    }
                    issueManagement {
                        system.set("Github issues")
                        url.set("https://github.com/equidis/sb-commons/issues")
                    }
                    ciManagement {
                        system.set("Github actions")
                        url.set("https://github.com/equidis/sb-commons/actions")
                    }
                    scm {
                        connection.set("scm:git:git@github.com:equidis/sb-commons.git")
                        developerConnection.set("scm:git:git@github.com:equidis/sb-commons.git")
                        url.set("https://github.com/equidis/sb-commons/")
                    }
                }
            }
        }
        repositories {
            maven {
                name = "Github_packages"
                setUrl("https://maven.pkg.github.com/equidis/sb-commons")
                credentials {
                    val githubActor: String? by project
                    val githubToken: String? by project
                    username = githubActor
                    password = githubToken
                }
            }
        }
    }
}
