# Dockerfile for Spring Boot application
FROM openjdk:17-jdk

WORKDIR /app

COPY ../target/backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090

CMD ["java", "-jar", "app.jar"]