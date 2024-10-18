FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/tu-aplicacion.jar /app/Protecto5toCicloAppApi-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/app/Protecto5toCicloAppApi-0.0.1-SNAPSHOT.jar"]
