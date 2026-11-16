# Java 17 기반 실행 환경
FROM eclipse-temurin:17-jre

# 컨테이너 내부 작업 디렉터리
WORKDIR /app

# 빌드된 Spring Boot JAR 복사
COPY build/libs/Sparta-AWS-0.0.1-SNAPSHOT.jar app.jar

# 애플리케이션 포트
EXPOSE 8080

# Spring Boot 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
