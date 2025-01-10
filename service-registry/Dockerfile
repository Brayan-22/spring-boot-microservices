FROM maven:3-amazoncorretto-21-alpine AS build

WORKDIR /app

COPY pom.xml ./
COPY src ./src

RUN mvn clean package -DskipTests -Pprod

FROM amazoncorretto:21-alpine3.18

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]