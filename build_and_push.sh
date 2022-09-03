gradlew clean build
docker build . -t nikolayshved/spring-rest:1.0.0

# docker run -ti --rm -e DATASOURCE_HOST=<your ip network> nikolayshved/spring-rest:1.0.0
# docker rmi nikolayshved/spring-rest:1.0.0
