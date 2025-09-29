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

## Install MySQL & MySQL Workbench
```shell
  brew install mysql
```
```shell
  brew install --cask mysqlworkbench
```


### Setup to connect MySQL DB

1. Start the server
    ```shell
    brew services start mysql
    ```
2. Open workbench
3. Connect to MySQL Connections
4. Open the `01-create-user.sql` script in workbench and execute the command. It will create a user 'spring' with password 'spring'

### Docs
- Swagger UI - `http://localhost:7070/v1/swagger-ui/index.html`
- 

### Package Sequence
1. springbootdemo - Core concepts, Annotations, Basics, DB connection
2. restcrud - Rest APIs, Exception Handling
3. restdbcrud - Rest APIs, DB Connection, Security Config
4. restjpadatacrud - Same as 3 + Use Spring Data JPA to reduce boiler code of DAO layer 