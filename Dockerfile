# Base JDK 21
FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp

# Copia o JAR para dentro do container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expõe porta da aplicação
EXPOSE 8080

# Comando para iniciar o Spring Boot
ENTRYPOINT ["java","-jar","/app.jar"]
