# Pekerjaan rumah 20 | Module 22

Tugas ini mengatur pipeline Continuous Integration (CI) menggunakan GitHub Actions untuk otomatisasi pengujian API dan UI Web.

## Konfigurasi GitHub Actions

Pipeline CI ini menggunakan GitHub Actions untuk otomatisasi pengujian API dan UI Web, dipicu oleh commit ke branch main atau saat pull request digabungkan ke branch tersebut.

### Langkah-langkah:
1. **Buat Pengetesan Automation API dan Web, di push ke branch main**
2. **Setup Workflow GitHub Actions**
File konfigurasi workflow GitHub Actions berada di `.github/workflows/main.yml`
3. **Setiap commit dipicu Github Actions akan melakukan pengujian**
![Screenshot](https://github.com/rdwaray/Final/blob/main/Screenshoot/1.png)
4. **Setelah pengujian selesai maka hasil report artifactnya bisa di cek**
   ![Screenshot](https://github.com/rdwaray/Final/blob/main/Screenshoot/2.png)
5. **Hasil Pengujian**
![Screenshot](https://github.com/rdwaray/Final/blob/main/Screenshoot/3.png)





