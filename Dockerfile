FROM eclipse-temurin:11-jdk

WORKDIR /app

COPY target/classes /app

CMD ["java", "-cp", "/app", "Main"]

