# Stage 1: Build the application
FROM gradle:jdk21 AS build


# Set the working directory
WORKDIR /deploykub

# Copy the Gradle wrapper and build files
COPY gradle gradle
COPY gradlew gradlew
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle

# Copy the source code
COPY src src

# Build the application
RUN gradle build -x test

# Stage 2: Create the Docker image with the built JAR
FROM eclipse-temurin:21-jre AS runtime

# Set the working directory
WORKDIR /deploykub

# Copy the built JAR file from the build stage
COPY --from=build /deploykub/build/libs/*.jar app.jar

# Expose the application port (change as necessary)
EXPOSE 8080

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]