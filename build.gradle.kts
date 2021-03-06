/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java Library project to get you started.
 * For more details take a look at the Java Libraries chapter in the Gradle
 * user guide available at https://docs.gradle.org/6.0/userguide/java_library_plugin.html
 */

plugins {
    val kotlinVersion = "1.3.21"
    idea
    id("org.springframework.boot") version "2.2.4.RELEASE"
    id("org.jetbrains.kotlin.jvm") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
}

repositories {
    jcenter()
}

dependencies {
    val cucumberVersion = "4.7.4"
    val springfoxVersion = "2.9.2"
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.keycloak:keycloak-spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-devtools")
    implementation("io.springfox:springfox-swagger2:${springfoxVersion}")
    implementation("io.springfox:springfox-swagger-ui:${springfoxVersion}")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("io.cucumber:cucumber-junit:${cucumberVersion}")
    testImplementation("io.cucumber:cucumber-java:${cucumberVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

}

configure<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension> {
    imports {
        mavenBom("org.keycloak.bom:keycloak-adapter-bom:8.0.2")
    }
}

springBoot {
    mainClassName = "ticket.TicketApplication"
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}