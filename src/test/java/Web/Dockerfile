# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk AS base

# Set the working directory in the container
WORKDIR /workspace

# Copy the gradle wrapper and gradle build files
COPY gradlew /workspace/
COPY gradle /workspace/gradle/
COPY build.gradle /workspace/
COPY settings.gradle /workspace/

# Make gradlew executable
RUN chmod +x gradlew

# Install dependencies
RUN ./gradlew dependencies

# Copy the rest of the application code
COPY . /workspace/

# Use a build argument to specify the default command
ARG TEST_COMMAND=webTest
CMD ["./gradlew", "${TEST_COMMAND}"]
