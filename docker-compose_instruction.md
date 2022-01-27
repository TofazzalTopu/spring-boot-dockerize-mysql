version: '3'

services:

  crud_db_manik (Database container name):
    image: mysql
    environment:
      - MYSQL_ROOT_PASSWORD=root
      - MYSQL_DATABASE=crud_db
      - MYSQL_USER=manik
      - MYSQL_PASSWORD=password
    ports:
      - 3306:3306

  prescription_dcompose (Spring Boot App container Name):
    image: prescription_dcompose (Spring Boot App image Name)
    restart: on-failure
    depends_on:
      - crud_db_manik
    ports:
      - 8080:8080
    environment:
      - DATABASE_HOST=crud_db_manik (Database container name)
      - DATABASE_USER=manik
      - DATABASE_PASSWORD=password
      - DATABASE_NAME=crud_db
      - DATABASE_PORT=3306