FROM alpine:3.16

RUN apk add openjdk11
COPY build/libs/spring-rest.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
