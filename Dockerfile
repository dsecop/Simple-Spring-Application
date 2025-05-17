FROM gradle:8.5-jdk17-alpine AS build
WORKDIR /app

COPY build.gradle settings.gradle ./
COPY gradlew gradlew.bat ./
COPY gradle ./gradle
COPY src ./src

RUN ./gradlew build --no-daemon -x test

FROM eclipse-temurin:17-jre-alpine-3.21 AS runtime
WORKDIR /app

RUN addgroup -S appgroup && adduser -S appuser -G appgroup && \
    rm -rf /var/cache/apk/*

COPY --from=build /app/build/libs/*.jar app.jar

RUN chown -R appuser:appgroup /app
USER appuser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
