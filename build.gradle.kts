import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotestVersion: String by project



plugins {
  kotlin("jvm") version "1.5.0"
}

group = "cl.ravenhill"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
//    implementation("io.kotest:kotest-runner-junit5-jvm:4.1.1")
  testImplementation(group = "io.kotest", name = "kotest-runner-junit5", version = kotestVersion)
  implementation(group = "io.kotest", name = "kotest-assertions-core", version = kotestVersion)
  testImplementation(group = "io.kotest", name = "kotest-property", version = kotestVersion)
}

tasks.test {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "13"
}