FROM eclipse-temurin:17-jdk
WORKDIR /app
LABEL authors="sda"
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]