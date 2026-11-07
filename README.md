# Sistem-SPBU
Sistem Manajemen Dispenser SPBU berbasis Java CLI (Command Line Interface) untuk Responsi Akhir Praktikum Pemrograman Berorientasi Objek (PBO). Mengimplementasikan 10 konsep inti OOP (Encapsulation, Inheritance, Abstract Class, Polymorphism, &amp; Multiple Interface).

# Sistem Manajemen Dispenser SPBU (Java CLI)
Repositori ini berisi kode sumber (*source code*) proyek **Responsi Akhir Praktikum Pemrograman Berorientasi Objek (PBO)** Jurusan Informatika, Fakultas Teknik, Universitas Jenderal Soedirman.
Aplikasi ini merupakan **program berbasis baris perintah / konsol (Command Line Interface / Terminal)** murni menggunakan bahasa pemrograman **Java Standard Edition (Java SE) tanpa antarmuka grafis (Non-GUI)**. Fokus utama sistem adalah mendemonstrasikan arsitektur dan 10 pilar Pemrograman Berorientasi Objek secara kohesif pada domain **Sistem Dispenser SPBU**.

## Identitas Praktikan
* **Nama Lengkap** : Aba Ibrahim Akbar
* **NIM** : H1D025153
* **Shift KRS** : D
* **Shift Sekarang** : H-I
* **Digit Terakhir NIM** : 3
* **Tema Sistem** : SPBU (Stasiun Pengisian Bahan Bakar Umum)

## Deskripsi Arsitektur & Fitur Sistem
Sistem mensimulasikan operasional mesin dispenser BBM pada SPBU yang mengelola penyaluran **Bensin** (Pertamax & Pertamax Turbo) serta **Solar** (Bio Solar Subsidi). Seluruh interaksi, validasi stok tangki, pembatasan kuota subsidi QR, pencetakan struk transaksi, hingga penguncian darurat sensor keamanan dieksekusi dan ditampilkan langsung melalui *output* terminal.

### Pemenuhan 10 Persyaratan Teknis PBO:
1. **State dan Behavior**: Menggunakan atribut variabel objek, *method* prosedur (`void`), serta *method* fungsi yang mengembalikan nilai (`return value`).
2. **Immutability**: Mengimplementasikan konstanta global (`public static final String NAMA_SPBU`) dan atribut instans kekal (`private final String kodeDispenser`).
3. **Enkapsulasi dan Overloading**: Seluruh atribut berstatus `private` dengan akses melalui *getter* dan *setter*, menggunakan *keyword* `this`, serta menerapkan *Overloaded Constructor*.
4. **Inheritance**: Memiliki relasi pewarisan dari 1 *superclass* (`MesinDispenser`) ke 2 *subclass* (`DispenserBensin` dan `DispenserSolar`) menggunakan `extends`, dengan `Main` terpisah.
5. **Super Chaining**: Memanggil konstruktor induk dengan `super(...)` dan memanggil *method* induk dengan `super.tampilkanInfoDispenser()`.
6. **Method Overriding**: Menimpa *method* dari *superclass* pada *subclass* secara spesifik menggunakan anotasi `@Override`.
7. **Abstract Class**: Kelas induk `MesinDispenser` berstatus `abstract` dan memiliki *abstract method* `salurkanBBM(double jumlahLiter)`.
8. **Logika State Percabangan**: Implementasi `salurkanBBM()` memuat percabangan `if/else` yang memeriksa status aktif mesin, kuota, serta membaca dan mengurangi *state* `stokLiter` secara langsung.
9. **Polimorfisme Interface**: Menginstansiasi dan memanggil perilaku objek melalui variabel referensi bertipe *interface* (`LayananTransaksi` dan `KontrolKeamanan`).
10. **Multiple Interface**: Kelas `DispenserBensin` mengimplementasikan dua *interface* sekaligus (`implements LayananTransaksi, KontrolKeamanan`).

## Struktur Berkas (File Structure)
```text
src/
├── MesinDispenser.java     # Abstract Superclass
├── DispenserBensin.java    # Subclass 1 (implements LayananTransaksi, KontrolKeamanan)
├── DispenserSolar.java     # Subclass 2 (implements LayananTransaksi)
├── LayananTransaksi.java   # Interface 1 (Kontrak transaksi & struk)
├── KontrolKeamanan.java    # Interface 2 (Kontrak sensor & kunci darurat)
└── Main.java               # Class utama pengujian (Entry Point CLI)
```

## Screenshot Luaran Program (Terminal Output)

Berikut adalah bukti kompilasi (`javac *.java`) dan eksekusi program (`java Main`) melalui terminal PowerShell IntelliJ IDEA yang memverifikasi kesepuluh persyaratan teknis:

### Bagian 1: Uji Instansiasi, Immutability, dan Abstract Method
<img width="1917" height="1047" alt="Screenshot 2026-11-08 003103" src="https://github.com/user-attachments/assets/039e1de1-75ef-439a-8250-5657bfffb6bc" />

### Bagian 2: Logika State Percabangan, Polimorfisme, dan Multiple Interface
<img width="1917" height="1041" alt="Screenshot 2026-11-08 003017" src="https://github.com/user-attachments/assets/c50fb018-9e1b-4a7b-8e36-1e8a79fd33e4" />
