#Build Phase

FROM maven:4.0.0 as build

COPY src /fibonacci/src
COPY pom.xml /fibonacci
RUN mvn -f "e:\Spring-workspace\fibonacci\pom.xml" clean package


# Package stage
FROM openjdk:11-jre-slim

WORKDIR /fibonacci

# ADD target/fibonacci-0.0.1-SNAPSHOT.jar fibonacci/fibonacci.jar 
ADD application-config.yml /fibonacci/application-config.yml

COPY / .


EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/fibonacci-0.0.1-SNAPSHOT.jar", "server", "application-config.yml"]


