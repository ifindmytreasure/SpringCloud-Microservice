FROM hub.c.163.com/library/java:8-jdk-alpine

MAINTAINER colin colin@163.com

ADD api-gateway-0.0.1-SNAPSHOT.jar gateway.jar

EXPOSE 8901

ENTRYPOINT ["java", "-jar", "/gateway.jar"]