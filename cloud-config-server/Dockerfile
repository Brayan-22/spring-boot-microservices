FROM maven:3-amazoncorretto-21-al2023 AS build

WORKDIR /app

COPY pom.xml ./
COPY src ./src

RUN mvn clean package -DskipTests -Pprod

FROM amazoncorretto:21-al2023-headless

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 9196

ENTRYPOINT ["java", "-jar", "app.jar"]