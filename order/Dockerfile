FROM hub.c.163.com/library/java:8-jdk-alpine

MAINTAINER colin colin@163.com

ADD server-0.0.1-SNAPSHOT.jar order.jar

EXPOSE 8902

ENTRYPOINT ["java", "-jar", "/order.jar"]