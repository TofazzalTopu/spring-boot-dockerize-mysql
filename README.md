# Project Title

## Sample Spring Boot application for Prescription Entry
* Project home url: http://localhost:8080/login
* Create User using Create user form (There is a register here link in login form).
* Use your new user name and pass for login to the application.


## Prerequisites
* JDK-8
* Spring Boot - 2.1.0
* Mysql


## Steps to create Dockerfile
1.	Add filename in maven.
2.	create a file name should be exactly 'Dockerfile' in project root directory.
3.	Add below lines in Dockerfile

--------------
FROM openjdk:8

EXPOSE 8060

ADD target/prescription.jar prescription.jar

ENTRYPOINT ["java", "-jar", "prescription.jar"]

---------------

•   Star docker: systemctl start docker or start docker by docker quickstart.

•   Build docker image: docker build –t target/prescription.jar .

•	Show docker Images: docker image ls

•	Run docker image: docker run –p 9090:8080 target/prescription.jar

•	docker run -p 8086:8086 prescription --name prescription --link crud_db:mysql -d prescription

•	Docker image list: docker image ls

•	Remove docker image: docker image rm < imageid>

•	Docker container list: docker ps –a

•	Start a Docker container :  docker start < container Id>

•	Stop a Docker container :  docker stop < container Id>

•	Remove container: docker container rm < containerid>

•	To run Docker container: docker logs <container id>


*	Push to Docker Hub:

•	docker tag target/prescription.jar tofazzal/prescription.jar

•	docker push tofazzal/prescription.jar


*	Pull from docker:

•	docker pull tofazzal/prescription.jar

•	docker run -p 9090:8080 tofazzal/prescription.jar


## Install Mysql: 
* docker pull mysql
* Create a new mysql database: I create database: crud_db.

* Execute below commands to create mysql database container: 
 (Here our database container name: crud_db_manik)

1.	docker run --name crud_db_manik  -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=crud_db  -e MYSQL_USER=manik -e MYSQL_PASSWORD=password -d mysql:5.7

Start a Docker container (database):	docker start crud_db_manik
Run the Docker container (database):	docker logs crud_db_manik

* Run our Spring Boot application container: (Here our Spring Boot application container name: prescription)
1.	docker run -p 8067:8060 --name=prescription --link crud_db_manik:mysql  -d prescription
2.	docker logs prescription

*  application.properties

Database Connection Properties in application.properties file: change ‘localhost’ to ‘crud_db_manik’

•	spring.datasource.url=jdbc:mysql://crud_db_manik:3306/crud_db?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false&autoReconnect=true&failOverReadOnly=false&maxReconnects=10

•	spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

•	spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

•	spring.datasource.username=manik

•	spring.datasource.password=password

-----------------

## Happy dockerising