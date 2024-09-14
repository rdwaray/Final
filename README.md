# Final Project
Repository ini berisi framework uji otomatis untuk Web UI dan API, dibangun dengan Java, Gradle, dan Cucumber, serta alat-alat terkait.
##Struktur Folder
- **src/test/java/**:
    - **API**: Berisi kode uji API, termasuk definisi langkah dan file fitur.
    - **Web**: Berisi kode uji Web UI, termasuk definisi langkah dan file fitur.
- **src/test/resources**:
    - **API**: Berisi file fitur Gherkin untuk pengujian API.
    - **Web**: Berisi file fitur Gherkin untuk pengujian Web UI.
- **build.gradle**: File build Gradle untuk mengelola dependensi dan tugas.
- **.github/workflows**: Konfigurasi workflow GitHub Actions.
- **src/test/java**:
  - **testRunnerAPI**: kelas dalam framework uji otomatis API yang digunakan untuk menjalankan pengujian.
  - **testRunnerWeb**: kelas dalam framework uji otomatis API yang digunakan untuk menjalankan pengujian.

## Tools dan library
- **Java**: Bahasa pemrograman yang digunakan untuk implementasi uji.
- **Gradle**: Alat otomatisasi build yang digunakan untuk mengelola dependensi dan tugas.
- **Cucumber**: Digunakan untuk menulis tes dalam format Gherkin dan menjalankannya.
- **RestAssured**: Library untuk pengujian API.
- **Selenium**: Library uji Web UI.
- **JUnit**: Kerangka uji yang digunakan bersama Cucumber.
- **Cucumber Report Plugin**: Untuk menghasilkan laporan dalam format HTML dan JSON.

## Menjalankan Tes

### Gradle

1. **Test API**
- Gunakan = ./gradlew apiTest

2. **Test Web**
- Gunakan =  ./gradlew WebTest

## Github Workflow
Workflow GitHub Actions, yang didefinisikan di .github/workflows, menjalankan tes secara manual dan saat ada permintaan tarik untuk memastikan berbagai skenario diuji.
