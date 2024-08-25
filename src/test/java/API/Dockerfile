# Menggunakan image OpenJDK 17 sebagai base image
FROM eclipse-temurin:17-jdk

# Menetapkan direktori kerja di dalam container
WORKDIR /workspace

# Menyalin seluruh kode aplikasi dan file Gradle ke dalam container
COPY . /workspace/

# Membuat gradlew executable dan menginstal dependensi Gradle
RUN chmod +x gradlew && \
    ./gradlew dependencies

# Menginstal dependensi Gradle (jika diperlukan)
RUN ./gradlew --no-daemon assemble

# Perintah default untuk menjalankan pengujian API
CMD ["./gradlew", "apiTest"]
