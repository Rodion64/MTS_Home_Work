FROM ubuntu:latest
LABEL authors="sushc"
ARG JAR=build/libs/*.jar
COPY ${JAR} HomeWork-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "HomeWork-1.0-SNAPSHOT.jar"]