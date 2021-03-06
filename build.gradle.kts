plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.30"
    id("org.jetbrains.kotlin.kapt") version "1.4.30"
    kotlin("plugin.serialization") version "1.4.30"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.30"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("io.micronaut.application") version "1.4.2"
}

// https://octoperf.com/blog/2019/07/25/kraken-gradle-multi-project-builds-for-maven-users/#dependency-management

version = "0.1"
group = "com.example1"

val kotlinVersion=project.properties.get("kotlinVersion")

repositories {
    mavenLocal()
    mavenCentral()
}

micronaut {
    runtime("netty")
    testRuntime("kotest")
    processing {
        incremental(true)
        annotations("com.example1.*")
    }
}

val vertxVertion= "4.0.2"
val crabzillaVersion = "0.0.9-snapshot-4"
val kotlinSerializationVersion = "1.1.0"

// https://tomgregory.com/how-to-use-gradle-api-vs-implementation-dependencies-with-the-java-library-plugin/

dependencies {
    implementation("io.micronaut:micronaut-validation")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut:micronaut-http-client")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinSerializationVersion")
    implementation(platform("io.vertx:vertx-stack-depchain:$vertxVertion"))
    implementation("io.vertx:vertx-core")
    implementation("io.vertx:vertx-lang-kotlin")
    implementation("io.github.crabzilla:crabzilla-core:$crabzillaVersion")
    implementation("io.github.crabzilla:crabzilla-pg-client:$crabzillaVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinSerializationVersion")
    implementation("io.nats:java-nats-streaming:2.2.3")

    api("io.vertx:vertx-pg-client")
    api("io.github.zero88:jooqx-core:1.0.0")

    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
}

application {
    mainClass.set("com.example1.application.ApplicationKt")
}

java {
    sourceCompatibility = JavaVersion.toVersion("11")

}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = listOf("-Xallow-result-return-type")
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = listOf("-Xallow-result-return-type")
        }
    }

}
