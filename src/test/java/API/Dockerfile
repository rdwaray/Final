# Menggunakan image dasar Ubuntu
FROM ubuntu:20.04

# Menetapkan variabel lingkungan untuk non-interaktif
ENV DEBIAN_FRONTEND=noninteractive

# Menginstal dependensi dasar dan mengupdate daftar paket
RUN apt-get update && \
    apt-get install -y \
    wget \
    gnupg \
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
    && apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Menambahkan kunci GPG untuk repositori Google
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list'

# Menginstal Google Chrome
RUN apt-get update && \
    apt-get install -y google-chrome-stable && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Menetapkan direktori kerja di dalam container
WORKDIR /workspace

# Menyalin seluruh kode aplikasi ke dalam container
COPY ../gradlew /workspace/
COPY ../gradle /workspace/gradle/
COPY ../build.gradle /workspace/
COPY ../settings.gradle /workspace/

# Membuat gradlew executable
RUN chmod +x ./gradlew

# Menginstal dependensi Gradle dan menjalankan tes
RUN ./gradlew dependencies && \
    ./gradlew --no-daemon test

# Menentukan perintah default untuk menjalankan pengujian
CMD ["./gradlew", "apiTest"]

# Menambahkan metadata image
LABEL maintainer="your-email@example.com" \
      description="Docker image for running Gradle tests with Google Chrome"