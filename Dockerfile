# Start with a base image containing Java runtime
FROM maven:3.5-jdk-8
#FROM openjdk:8-jdk-alpine
#
## Add Maintainer Info
#LABEL maintainer="baljotmalhi01@gmail.com"
#
## Add a volume pointing to /tmp
#VOLUME /tmp
#
## Make port 8080 available to the world outside this container
#EXPOSE 5000
#
## The application's jar file
#ARG JAR_FILE=target/AwesomeProject-0.0.1-SNAPSHOT.jar
#
## Add the application's jar to the container
#ADD ${JAR_FILE} app.jar
#
## Run the jar file
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]