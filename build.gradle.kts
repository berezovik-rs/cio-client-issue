import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "me.user"
version = "1.0-SNAPSHOT"

plugins {
    application
    kotlin("jvm") version "1.4.30"
}

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClassName = "CioClientApplicationKt"
}

dependencies {
    implementation("io.ktor:ktor-server-core:1.5.1")

    implementation("io.ktor:ktor-server-netty:1.5.1")
    implementation("io.ktor:ktor-server-cio:1.5.1")

    implementation("io.ktor:ktor-client-apache:1.5.1")
    implementation("io.ktor:ktor-client-cio:1.5.1")
    implementation("io.ktor:ktor-client-okhttp:1.5.1")
}
