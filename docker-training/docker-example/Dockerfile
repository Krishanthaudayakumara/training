# Base image with Java Development Kit (JDK)
FROM eclipse-temurin:17-jdk-jammy

# Label (optional)
LABEL authors="Krishantha"

# Copy the JAR file
COPY target/docker-example-1.0-SNAPSHOT.jar /app.jar

# Set the working directory
WORKDIR /

# Start the JAR application
CMD ["java", "-jar", "/app.jar"]
