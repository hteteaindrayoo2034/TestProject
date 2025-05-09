FROM openjdk:22
COPY ./target/TestProjects-1.0-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "TestProjects-1.0-jar-with-dependencies.jar"]