#
# Build stage
#
FROM maven:3.9.2 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /target/mertdenizgez-0.0.1-SNAPSHOT.jar mertdenizgez.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","mertdenizgez.jar"]