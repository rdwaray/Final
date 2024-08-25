# Menggunakan image OpenJDK 17 sebagai base image
FROM eclipse-temurin:17-jdk

# Menetapkan direktori kerja di dalam container
WORKDIR /workspace

# Menyalin file Gradle yang diperlukan dan menginstal dependensi Gradle
COPY gradlew /workspace/
COPY gradle /workspace/gradle/
COPY build.gradle /workspace/
COPY settings.gradle /workspace/

# Membuat gradlew executable dan menginstal dependensi Gradle
RUN chmod +x gradlew && \
    ./gradlew dependencies

# Menyalin sisa kode aplikasi ke dalam container
COPY . /workspace/

# Menginstal dependensi Gradle (jika belum dilakukan di langkah sebelumnya)
RUN ./gradlew --no-daemon assemble

# Perintah default untuk menjalankan pengujian API
CMD ["./gradlew", "webTest"]
