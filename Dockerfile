FROM openjdk:11.0.7
ADD target/pharmacy_store-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]