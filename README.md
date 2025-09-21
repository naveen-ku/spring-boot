## Run the project

Two ways to run the project:

```shell
  java -jar targert/file_name.jar
```

```shell
  ./mvnw spring-boot:run
```

## Spring boot starter security
When you add the spring-boot-starter-security dependency to pom.xml, it will restrict access to ALL requests. This is not limited to Spring Boot actuator. It will secure all endpoints.


### Lazy Initialization
Instead of adding @Lazy annotation we can also define global property related to in `application.properties`
```properties
spring.main.lazy-initialization=true
```
