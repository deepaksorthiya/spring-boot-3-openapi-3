[![Java Maven Build Test](https://github.com/deepaksorthiya/spring-boot-3-openapi-3/actions/workflows/maven-build.yml/badge.svg)](https://github.com/deepaksorthiya/spring-boot-3-openapi-3/actions/workflows/maven-build.yml)
[![Docker Hub badge][dockerhub-badge]][dockerhub]

[dockerhub-badge]: https://img.shields.io/docker/pulls/deepaksorthiya/spring-boot-3-openapi-3

[dockerhub]: https://hub.docker.com/repository/docker/deepaksorthiya/spring-boot-3-openapi-3

---

### ** Spring Boot 3 OpenAPI 3 **

---

# Getting Started

## Requirements:

```
Git: 2.51+
Spring Boot: 3.5.9
Maven: 3.9+
Java: 24
Docker Desktop: Tested on 4.53+
```

## Clone this repository:

```bash
git clone https://github.com/deepaksorthiya/spring-boot-3-openapi-3.git
cd spring-boot-3-openapi-3
```

## Build Project

```bash
./mvnw clean package
```

## Run Project:

```bash
./mvnw spring-boot:run
```

## Run Tests:

```bash
./mvnw clean verify
```

## (Optional)Build Docker Image(Docker should be running)

```bash
./mvnw clean spring-boot:build-image -DskipTests
```

## (Optional)Running On Docker Image

```bash
docker run -p 8080:8080 --name spring-boot-3-openapi-3 deepaksorthiya/spring-boot-3-openapi-3:0.0.1-SNAPSHOT
```

## Testing Endpoints

http://localhost:8080/swagger-ui.html

Test content negotiation APIs
Postman
Collection [Link](https://www.postman.com/deepaksorthiya/workspace/public-ws/collection/12463530-ba448821-b03d-4d5d-b0a1-9b9d1fc6cac0?action=share&creator=12463530&active-environment=12463530-55c10ebe-548f-4c1b-a5ec-4d4ed996c033)

## Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/current/maven-plugin/build-image.html)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/current/reference/actuator/index.html)
* [Spring Web](https://docs.spring.io/spring-boot/current/reference/web/servlet.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/current/reference/data/sql.html#data.sql.jpa-and-spring-data)

## Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)