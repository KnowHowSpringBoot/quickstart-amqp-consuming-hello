FROM openjdk:17.0.2-slim

RUN apt update && apt install -y unzip curl mc netcat iputils-ping less vim nano wget

WORKDIR /app

COPY ./target/*.jar /app/app.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Duser.timezone=UTC -jar /app/app.jar"]
EXPOSE 8080
