FROM hub.c.163.com/library/java:8-jdk-alpine

MAINTAINER colin colin@163.com

ADD product-0.0.1-SNAPSHOT.jar product.jar

EXPOSE 8901

ENTRYPOINT ["java", "-jar", "/product.jar"]