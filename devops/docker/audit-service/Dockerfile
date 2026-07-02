FROM eclipse-temurin:21-jre

LABEL service="audit-service"

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8095

ENV JAVA_OPTS="-Xms256m -Xmx512m"

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]