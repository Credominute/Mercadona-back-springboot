FROM maven:3.8.6-eclipse-temurin-17
COPY . .
RUN mvn install
EXPOSE 8080
ENTRYPOINT ["java","-jar","./target/promoweb-0.0.1-SNAPSHOT.war"]