FROM openjdk:11-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} tpachat.jar
ENTRYPOINT ["java","-jar","/achat.jar"]
EXPOSE 8090
