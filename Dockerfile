# =========================================
# Dockerfile: Android SDK 30 + Build-Tools 35 + JDK 17 + gradle
# =========================================

FROM openjdk:17.0.1

COPY target/ap-backend-1.0.0.jar /app/app.jar
WORKDIR /app


CMD ["java", "-jar", "/app/app.jar", "--spring.profiles.active=prod"]