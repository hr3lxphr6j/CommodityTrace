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

```
docker run --name mariadb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=8681700 -d mariadb --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```
```mysql
CREATE DATABASE commodity_trace
```
* Redis
```
docker run --name redis -p 6379:6379 -d redis
```
## 编译打包
```
./gradle build
```
## 运行
```
./gradle bootRun
```
or
```
./gradle build
java -jar build/libs/commoditytrace-0.1.jar
```