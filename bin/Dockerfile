FROM maven:3.8.2-jdk-8

WORKDIR /spring-app
COPY . .
RUN mvn clean install
ENTRYPOINT cat /etc/hosts

CMD mvn spring-boot:run
