# Commodity Trace 
课程设计《农产品追踪溯源系统》Restful服务端
## 使用技术&框架
* Spring Boot
* Spring Data Jpa
* Spring Security (使用Http Basic)
* Spring Cache (使用Redis)
* Spring Validator
* Kotlin
## 数据库部署
* MariaDB

```Bash
docker run --name mariadb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mariadb --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```
```mysql
CREATE DATABASE commodity_trace;
```
* Redis
```Bash
docker run --name redis -p 6379:6379 -d redis
```
## 编译打包
```Bash
./gradle build
```
## 运行
```Bash
./gradlew bootRun
```
or
```Bash
./gradlew build
java -jar build/libs/commoditytrace-0.1.jar
```