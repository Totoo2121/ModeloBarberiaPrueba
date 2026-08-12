FROM eclipse-temurin:22-jdk AS builder

WORKDIR /app

COPY . .

RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests -B

FROM eclipse-temurin:22-jre

ENV TZ=America/Argentina/Buenos_Aires

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 10000

ENV PORT=10000

ENTRYPOINT ["java", "-jar", "app.jar"]