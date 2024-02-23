# Stage 0: Pull the required base image
FROM openjdk:17-jdk-slim as base

# Stage 1: Build the application
FROM base as build

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper files
COPY mvnw .
COPY ../../../Desktop/helmes/backend/.mvn .mvn

# Copy the project descriptor files
COPY pom.xml .

# Copy the source code
COPY src src

# Set the executable permission for the Maven wrapper script
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Stage 2: Create the production image
FROM base

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/sonnik.jar .

# Expose the application port (if necessary)
EXPOSE 8080

# Set the entrypoint command
ENTRYPOINT ["java", "-jar", "sonnik.jar"]
