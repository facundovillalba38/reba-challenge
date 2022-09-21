FROM tomcat:10.1.0
VOLUME /tmp
COPY target/Reba-Challenge-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/Reba-Challenge-0.0.1-SNAPSHOT.war
EXPOSE 8081
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=reba -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/Reba-Challenge-0.0.1-SNAPSHOT.war" ]
