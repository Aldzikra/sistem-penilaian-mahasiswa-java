# java-student-grading-system

Aplikasi desktop sederhana untuk mengelola data nilai mahasiswa. Proyek ini dibuat menggunakan **Java Swing GUI** dan terhubung ke database **MySQL** dengan menerapkan pola arsitektur **MVC (Model-View-Controller)** agar struktur kodenya lebih rapi dan gampang dipahami.

## 🚀 Fitur Aplikasi
* **Navigasi Menu:** Menggunakan `JMenuBar` untuk perpindahan antar halaman.
* **Manajemen Data (CRUD):** Bisa tambah, lihat, ubah, dan hapus data nilai.
* **Validasi Hapus:** Ada pop-up konfirmasi dari `JOptionPane` sebelum data benar-benar dihapus biar gak sengaja kepencet.
* **Cek Koneksi:** Sistem otomatis mengecek status database di awal (main class) sebelum aplikasi terbuka.

## 🏗️ Struktur Package (MVC)
* `config` : Pengaturan koneksi database (`koneksi.java`).
* `controller` : Menangani logika bisnis aplikasi (`NilaiController.java`).
* `model` : Representasi objek dan query database (`NilaiModel.java`, dll).
* `view` : Desain interface/tampilan UI (`MenuUtama.java`, `FormNilai.java`, dll).

## 🛠️ Tech Stack & Tools
* **Bahasa:** Java (JDK 8 ke atas)
* **IDE:** Apache NetBeans
* **Database:** MySQL (XAMPP / Laragon)

## 🏃 Cara Menjalankan Project
1. Clone repositori ini ke lokal:
   ```bash
   git clone [https://github.com/Aldzikra/java-student-grading-system.git](https://github.com/Aldzikra/java-student-grading-system.git)
