# =========================================
# Dockerfile: Android SDK 30 + Build-Tools 35 + JDK 17 + gradle
# =========================================

FROM openjdk:17.0.1

COPY eladmin-system/target/eladmin-system-2.7.jar /app/eladmin-system-2.7.jar
WORKDIR /app

ENV DB_HOST=apk8848.qzz.io
ENV REDIS_HOST=apk8848.qzz.io

CMD ["java", "-jar", "/app/eladmin-system-2.7.jar", "--spring.profiles.active=prod"]