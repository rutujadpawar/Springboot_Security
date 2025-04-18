# Use an official OpenJDK 17 runtime as base image
FROM openjdk:17-jdk-slim

# Copy the built JAR file into the container
COPY build/libs/Springboot_Security-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (optional, but good for testing)
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java", "-jar", "/app.jar"]
