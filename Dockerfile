FROM openjdk:8-jdk-alpine
RUN mvn clean package
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api-suacontabasa.jar
ENTRYPOINT ["java","-jar","/api-suacontabasa.jar"]