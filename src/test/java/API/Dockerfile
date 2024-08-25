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

# Menginstal dependensi Gradle
RUN ./gradlew dependencies --no-daemon

# Menginstal QEMU dan dependensi lainnya
RUN apt-get update && apt-get install -y \
    qemu \
    qemu-system-x86 \
    qemu-utils

# Contoh menjalankan emulator QEMU
# (Anda mungkin memerlukan konfigurasi tambahan tergantung pada sistem operasi dan file image yang digunakan)
# RUN qemu-system-x86_64 -drive file=my-image.qcow2,format=qcow2

# Menginstal dependensi Gradle (jika diperlukan) dan menjalankan tes
RUN ./gradlew --no-daemon test

# Perintah default untuk menjalankan pengujian API
CMD ["./gradlew", "apiTest"]
