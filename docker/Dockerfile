FROM openjdk:17-jdk-alpine

WORKDIR /app

# Copy the JAR file and the start script
COPY target/docker-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
