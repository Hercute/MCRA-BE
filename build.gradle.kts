plugins {
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.5"
	kotlin("jvm") version "1.9.24"
	kotlin("plugin.spring") version "1.9.24"
	kotlin("plugin.noarg") version "1.8.22" // noArg
	kotlin("kapt") version "1.8.22" // 쿼리DSL

}

group = "com.hercute"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

noArg {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

val queryDslVersion = "5.0.0"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	implementation("org.springframework.boot:spring-boot-starter-aop")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	implementation("org.springframework.boot:spring-boot-starter-validation") //벨리데이션
	implementation("com.querydsl:querydsl-jpa:$queryDslVersion:jakarta") // 쿼리DSL
	kapt("com.querydsl:querydsl-apt:$queryDslVersion:jakarta") // 쿼리DSL

	implementation("org.springframework.boot:spring-boot-starter-security")//시큐리티
	implementation("io.jsonwebtoken:jjwt-api:0.12.3")//시큐리티
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.3")//시큐리티
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.3")//시큐리티

	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

	implementation("org.springframework.boot:spring-boot-starter-jdbc")

	implementation ("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
	implementation ("com.fasterxml.jackson.core:jackson-databind")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
