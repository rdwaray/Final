# Menggunakan image dasar Ubuntu
FROM ubuntu:20.04

# Menginstal dependensi dasar
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    openjdk-17-jdk \
    libx11-dev \
    libxkbcommon-x11-0 \
    libxcomposite1 \
    libxdamage1 \
    libxrandr2 \
    libxtst6 \
    libnss3 \
    libgbm1 \
    libatspi2.0-0 \
    libgdk-pixbuf2.0-0 \
    && rm -rf /var/lib/apt/lists/*

# Menginstal Google Chrome
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
    && apt-get install -y ./google-chrome-stable_current_amd64.deb \
    && rm google-chrome-stable_current_amd64.deb

# Menetapkan direktori kerja di dalam container
WORKDIR /workspace

# Menyalin seluruh kode aplikasi ke dalam container
COPY . /workspace/

# Membuat gradlew executable
RUN chmod +x ./gradlew

# Menginstal dependensi Gradle
RUN ./gradlew dependencies

# Menginstal dependensi Gradle (jika diperlukan) dan menjalankan tes
RUN ./gradlew --no-daemon test

# Menentukan perintah default untuk menjalankan pengujian
CMD ["./gradlew", "apiTest"]
