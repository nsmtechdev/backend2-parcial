FROM openjdk:17-jdk-alpine
RUN apk update && apk add bash
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN chmod +x wait-for-it.sh
ENTRYPOINT ["eureka-server:8761", "--", "java", "-jar", "app.jar"]
EXPOSE 8087