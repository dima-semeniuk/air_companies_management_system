FROM openjdk:11-jdk-slim as builder
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
CMD ["java", "-jar", "application.jar"]

EXPOSE 8080