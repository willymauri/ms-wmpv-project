FROM openjdk:11
EXPOSE 8080
ADD target/wmpv-project.jar wmpv-project.jar
ENTRYPOINT ["java", "-jar", "wmpv-project.jar"]