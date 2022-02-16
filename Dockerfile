FROM openjdk:8
COPY demo/target/webapp.jar webapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar" , "/webapp.jar", "--server.port=5050"]