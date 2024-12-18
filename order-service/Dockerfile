# Use an official OpenJDK runtime as a parent image
FROM amazoncorretto:21-al2023-headless

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file from the host machine to the container
COPY target/*.jar app.jar

# Expose the port that the application will run on
EXPOSE 9092

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]