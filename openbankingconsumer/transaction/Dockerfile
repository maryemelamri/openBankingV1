FROM maven:3.2.2-openjdk-17 AS builder
WORKDIR /app
COPY ./src ./src
COPY ./pom.xml .
RUN mvn clean package

FROM openjdk:17-jdk-alpine

EXPOSE 8084
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} transactioncons.jar
ENTRYPOINT ["java","-jar","/transactioncons.jar"]