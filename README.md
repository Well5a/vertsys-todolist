# Todo List

## Description:
Project for "Verteilte Systeme" lecture at HS Esslingen, SS18.

### Technologies:
* Spring Boot 
* Docker
* MySQL
* Thymeleaf

## Task:
* https://github.com/maeddes/HSE18_01
* http://gist.asciidoctor.org/?5d53ec092a4f79907c653388092f619c

## Build the app:
```
mvn clean package
```

## App usage (mappings):
* http://localhost:8080/ui for list of todos
* `curl -X POST localhost:8080/task` to add a task to the list
* `curl -X DELETE localhost:8080/task` to delete a task from the list

## Docker commands:
* Create image: `docker build -t helloworld .`
* Run container: `docker run -p 1337:8080 helloworld` (app is available on port 1337)
* Push image to Docker Hub: https://docs.docker.com/docker-cloud/builds/push-images/

## Start and use the MySql Container:
* Create container: `docker run -d --name todomysql -e MYSQL_ROOT_PASSWORD="root" -e MYSQL_DATABASE="tododb" -p 3306:3306 mysql`
* Access bash: `docker exec -it todomysql bash`
* Login: `mysql -p (pw=root)`
* Create custom user: `create user 'vertsys'@'%' identified by 'vertsys';`
* Grant privileges for user: `grant all privileges on tododb.* to 'vertsys'@'%';`


## Authors:
* Marcel Weller (maweit06)
* David Schick  (dascit12)

