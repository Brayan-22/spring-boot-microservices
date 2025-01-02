FROM amazoncorretto:21-al2023-headless

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 9196

ENTRYPOINT ["java","-jar","app.jar"]