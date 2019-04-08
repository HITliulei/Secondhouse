FROM java:8
MAINTAINER liulei
ADD target/demo-0.0.1-SNAPSHOT.jar secondhouse-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","secondhouse-0.0.1-SNAPSHOT.jar"]