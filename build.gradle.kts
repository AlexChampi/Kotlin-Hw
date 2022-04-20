import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    kotlin("plugin.jpa") version "1.6.10"
}

group = "ru.tinkoff.fintech.homework"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-web:2.6.6")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.6")
    implementation("com.h2database:h2:2.1.210")
    implementation("org.liquibase:liquibase-core:4.9.1")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.7")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("com.ninja-squad:springmockk:3.1.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.0")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.2.2")
    testImplementation("io.mockk:mockk:1.12.3")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}