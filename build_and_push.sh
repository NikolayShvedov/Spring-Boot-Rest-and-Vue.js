gradlew clean build
docker build . -t nikolayshved/spring-rest:1.0.0

# run docker container
# docker run -p 8081:9000 -d --name spring-rest-service nikolayshved/spring-rest:1.0.0
# stop vacation-service container
# docker stop spring-rest-service
# remove vacation-service container
# docker rm spring-rest-service

# docker run --name postgres-docker -p 5433:5432 -e POSTGRES_PASSWORD=1234 -d postgres:13
