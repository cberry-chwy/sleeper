import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.0"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("jvm") version "1.4.10"
    kotlin("plugin.spring") version "1.4.10"
    id("org.openapi.generator") version "4.3.0"
}

val kotlinVersion = "1.4.10"

group = "com.cberry"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("com.squareup.okhttp3:okhttp:4.9.0")

    implementation( "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation( "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation( "com.squareup.moshi:moshi-kotlin:1.9.2")
    implementation( "com.squareup.moshi:moshi-adapters:1.9.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<KotlinCompile> {
    dependsOn("openApiGenerate")
}

openApiGenerate {
    // https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/kotlin-spring.md
    generatorName.set("kotlin")
    inputSpec.set("$rootDir/reference/Sleeper.v1.yaml")
    outputDir.set("$rootDir")

    configOptions.put("packageName", "com.cberry.sleeper.generated.client")
}

tasks.register("cleanGeneratedSource", org.gradle.api.tasks.Delete::class) {
    delete("$projectDir/src/main/kotlin/com/cberry/sleeper/generated/")
}

getTasksByName("clean", false)
    .firstOrNull()
    ?.dependsOn("cleanGeneratedSource")

