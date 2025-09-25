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