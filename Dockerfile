FROM maven:3.8.6-eclipse-temurin-17-alpine

WORKDIR /app

COPY . .

RUN mvn package -Dmaven.test.skip=true

RUN mv target/*.jar target/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/target/app.jar"]
