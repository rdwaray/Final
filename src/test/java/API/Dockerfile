# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk

# Set the working directory in the container
WORKDIR /workspace

# Copy all necessary files
COPY . /workspace/

# Make gradlew executable
RUN chmod +x gradlew

# Install dependencies
RUN ./gradlew dependencies

# Default command to run tests
CMD ["./gradlew", "apiTest"]
