FROM hub.c.163.com/library/java:8-jdk-alpine

MAINTAINER colin colin@163.com

ADD config-0.0.1-SNAPSHOT.jar config.jar

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "/config.jar"]