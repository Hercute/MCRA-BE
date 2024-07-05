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
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")	 // JPA

	implementation("org.springframework.boot:spring-boot-starter-validation") //벨리데이션
	implementation("com.querydsl:querydsl-jpa:$queryDslVersion:jakarta") // 쿼리DSL
	kapt("com.querydsl:querydsl-apt:$queryDslVersion:jakarta") // 쿼리DSL

	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

	implementation("org.springframework.boot:spring-boot-starter-jdbc")

	implementation ("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
	implementation ("com.fasterxml.jackson.core:jackson-databind")

	//implementation("io.springfox:springfox-boot-starter:3.0.0") //스웨거

	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0") //스프링독스

	// PostgreSQL 의존성
	implementation("org.postgresql:postgresql")

	// H2 데이터베이스 의존성
	implementation("com.h2database:h2:2.1.214")


	runtimeOnly("org.postgresql:postgresql") //포스트그레스SQL
	runtimeOnly("com.h2database:h2") //h2
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
