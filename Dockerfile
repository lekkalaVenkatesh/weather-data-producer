From openjdk:11
copy ./target/weather-data-producer-0.0.1-SNAPSHOT.jar weather-data-producer-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","weather-data-producer-0.0.1-SNAPSHOT.jar"]