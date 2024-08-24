# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk

# Set the working directory in the container
WORKDIR /Final

# Copy the gradle wrapper and gradle build files
COPY gradlew /Final/
COPY gradle /Final/gradle/
COPY build.gradle /Final/
COPY settings.gradle /Final/

# Make gradlew executable
RUN chmod +x gradlew

# Install dependencies
RUN ./gradlew dependencies

# Copy the rest of the application code
COPY . /Final/

# Default command to run tests
CMD ["./gradlew", "test"]
