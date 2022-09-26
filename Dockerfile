FROM openjdk:11-jdk
ADD target/reba-challenge.jar reba-challenge.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "reba-challenge.jar"]