FROM openjdk:8
ADD target/TpAchat.jar TpAchat.jar
EXPOSE 8090
ENTRYPOINT ["java" , "-jar" , "TpAchat.jar"]
