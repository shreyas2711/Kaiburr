# Dockerfile for Spring Boot application
FROM openjdk:17-jdk

WORKDIR /app

COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

WORKDIR /app

EXPOSE 9090

# Command to run the application
CMD ["java", "-jar", "app.jar"]