# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk

# Set the working directory in the container
WORKDIR /workspace

# Copy all necessary files at once
COPY . /workspace/

# Make gradlew executable
RUN chmod +x gradlew

# Install dependencies and run tests
RUN ./gradlew dependencies && ./gradlew apiTest
