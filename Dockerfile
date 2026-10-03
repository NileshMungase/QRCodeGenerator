FROM eclipse-temurin:25-jre
WORKDIR /app
COPY target/project-pipeline-1.0.0.jar app.jar
EXPOSE 8045
ENTRYPOINT ["java","-jar","app.jar"]
