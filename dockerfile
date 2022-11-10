FROM openjdk:8
ADD target/achat.jar achat.jar
EXPOSE 8090
ENTRYPOINT ["java" , "-jar" , "TpAchat.jar"]
