# FROM eventuateio/eventuate-examples-docker-images-java-example-base-image:BUILD-5
# COPY build/libs/customer-service.jar service.jar


FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/customer-service.jar
ADD ${JAR_FILE} service.jar
ENTRYPOINT ["java","-jar","-Xmx64m","/service.jar"]