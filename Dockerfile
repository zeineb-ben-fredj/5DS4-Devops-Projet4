FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/DevOps-Project-1.0.jar DevOps-Project-1.0.jar
ENTRYPOINT ["java", "-jar", "/devps-project-1.0.jar"]
