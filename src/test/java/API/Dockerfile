# Menggunakan image OpenJDK 17 sebagai base image
FROM eclipse-temurin:17-jdk

# Menetapkan direktori kerja di dalam container
WORKDIR /workspace

# Menyalin seluruh kode aplikasi dan file Gradle ke dalam container
COPY . /workspace/

# Memeriksa isi direktori untuk debugging
RUN ls -la /workspace

# Membuat gradlew executable
RUN chmod +x gradlew

# Memeriksa file gradlew untuk debugging
RUN ls -la gradlew

# Menginstal dependensi Gradle
RUN ./gradlew dependencies --no-daemon

# Menginstal dependensi Gradle (jika diperlukan) dan menjalankan tes
RUN ./gradlew --no-daemon test

# Perintah default untuk menjalankan pengujian API
CMD ["./gradlew", "apiTest"]
