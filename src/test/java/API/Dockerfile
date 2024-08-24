# Use an official OpenJDK 20 runtime as a parent image
FROM eclipse-temurin:20-jdk

# Set the working directory in the container
WORKDIR /workspace

# Copy all necessary files
COPY . /workspace/

# Make gradlew executable
RUN chmod +x gradlew

# Install dependencies
RUN ./gradlew dependencies

# Use a build argument to specify the default command
ARG TEST_COMMAND=apiTest
CMD ["./gradlew", "${TEST_COMMAND}"]
