FROM openjdk:8
EXPOSE 8060
ADD target/prescription.jar prescription.jar
ENTRYPOINT ["java", "-jar", "prescription.jar"]