FROM maven:latest AS build
COPY pom.xml /tmp/
COPY src  /tmp/src/
WORKDIR /tmp/
RUN mvn -Dmaven.test.skip=true package

FROM openjdk:11.0.8-jdk
WORKDIR /tmp
COPY --from=build /tmp/target/stack-push-pop-service-*.*.*-SNAPSHOT.jar .
ENTRYPOINT [ "sh", "-c", "java -jar stack-push-pop-service-*.*.*-SNAPSHOT.jar"]