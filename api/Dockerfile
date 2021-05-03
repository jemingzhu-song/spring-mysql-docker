FROM openjdk:8

ENV WAIT_VERSION 2.7.2

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/$WAIT_VERSION/wait /wait

RUN chmod +x /wait

ADD target/api-0.0.1-SNAPSHOT.jar app.jar

CMD ["./wait", "&&", "java", "-jar", "app.jar"]
