FROM openjdk:11-jre

COPY items-0.0.1-SNAPSHOT.jar /opt/webapp.jar

CMD ["java", "-jar", "/opt/webapp.jar"]
