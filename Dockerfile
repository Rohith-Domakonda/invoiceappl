# # define base docker image or parent image
# FROM openjdk:17
# LABEL maintainer="Rohithspring.net"
# #copies the jar file to the docker image
# ADD target/Purchaseinvoice-0.0.1-SNAPSHOT.jar springboot-docker-demo.jar
# ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]


# Define base Docker image or parent image
FROM maven:3.8.4-openjdk-17 AS build
LABEL maintainer="Rohithspring.net"

# Set the working directory in the container
WORKDIR /app

# Copy the project files
COPY pom.xml .
COPY src ./src

# Build the project using Maven
RUN mvn clean install

# Create a new image with only the JAR file
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/Purchaseinvoice-0.0.1-SNAPSHOT.jar springboot-docker-demo.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]
