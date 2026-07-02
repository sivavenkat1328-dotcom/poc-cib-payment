FROM eclipse-temurin:21-jre

LABEL service="discovery-server"
LABEL application="CIB AI Payment Platform"

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8761

ENV JAVA_OPTS="-Xms256m -Xmx512m -XX:+UseContainerSupport"

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]