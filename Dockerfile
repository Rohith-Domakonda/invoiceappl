# define base docker image or parent image
FROM openjdk:17
LABEL maintainer="Rohithspring.net"
#copies the jar file to the docker image
ADD target/Purchaseinvoice-0.0.1-SNAPSHOT.jar springboot-docker-demo.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]