# Use an official amazon correto jdk runtime as a parent image
FROM amazoncorretto:21-al2023-headless

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file from the host machine to the container
COPY target/*.jar app.jar

# Expose the port that the application will run on
EXPOSE 9091

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]


#
#FROM maven:latest as build
#
#WORKDIR /app
#
#COPY pom.xml ./
#COPY src ./src
#
#RUN mvn clean package -DskipTests -Pprod
#
#FROM amazoncorretto:21-al2023-headless
#
#WORKDIR /app
#
#COPY --from=build /app/target/*.jar app.jar
#
#EXPOSE 9091
#
#ENTRYPOINT ["java", "-jar", "app.jar"]