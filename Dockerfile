# Use a lightweight JDK image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory to the container
COPY target/Scientific-Calculator-1.0-SNAPSHOT.jar app.jar

# Set the entrypoint to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
