# Final Project
Repository ini berisi framework uji otomatis yang mendukung pengujian Web UI dan API. Framework ini dibangun menggunakan Java, Gradle, Cucumber, dan alat-alat lainnya, yang terorganisir untuk memfasilitasi pengujian kedua jenis aplikasi tersebut.

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
  - **testRunnerAPI**:
  - **testRunnerWeb**:

## Tools dan library
- **Java**: Bahasa pemrograman yang digunakan untuk implementasi uji.
- **Gradle**: Alat otomatisasi build yang digunakan untuk mengelola dependensi dan tugas.
- **Cucumber**: Digunakan untuk menulis tes dalam format Gherkin dan menjalankannya.
- **RestAssured**: Perpustakaan untuk pengujian API.
- **Selenium**: Perpustakaan uji Web UI.
- **JUnit**: Kerangka uji yang digunakan bersama Cucumber.
- **Cucumber Report Plugin**: Untuk menghasilkan laporan dalam format HTML dan JSON.

## Menjalankan Tes

### Gradle

1. **Test API**
- Gunakan = ./gradlew apiTest

2. **Test Web**
- Gunakan =  ./gradlew WebTest

## Github Workflow
Workflow GitHub Actions didefinisikan di direktori .github/workflows. Workflow ini diatur untuk menjalankan tes pada pemicu manual dan permintaan tarik untuk memastikan bahwa tes dijalankan dalam berbagai skenario.