FROM  adoptopenjdk/openjdk11:ubi
MAINTAINER Denzil Gideon M. Daulo
COPY target/frontend-service-0.0.1-SNAPSHOT.jar frontend-service.jar
CMD java -jar frontend-service.jar