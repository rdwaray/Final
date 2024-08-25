# Menggunakan image OpenJDK 17 sebagai base image
FROM eclipse-temurin:17-jdk

# Menetapkan direktori kerja di dalam container
WORKDIR /workspace

# Menyalin file Gradle yang diperlukan
COPY gradlew /workspace/
COPY gradle /workspace/gradle/
COPY build.gradle /workspace/
COPY settings.gradle /workspace/

# Membuat gradlew executable
RUN chmod +x gradlew

# Menyalin sisa kode aplikasi ke dalam container
COPY . /workspace/

# Menginstal dependensi Gradle
RUN ./gradlew dependencies

# Perintah default untuk menjalankan pengujian API
CMD ["./gradlew", "apiTest"]
