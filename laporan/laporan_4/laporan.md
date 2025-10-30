# Laporan Modul 4: Pengenalan Object Oriented Programming
**Mata Kuliah:** Praktikum Pemrograman Berorientasi Objek   
**Nama:** Alif Riski Adriansyah  
**NIM:** 2024573010110
**Kelas:** TI 2A

---

## 1. Abstrak
Praktikum ini bertujuan untuk memahami konsep dasar Pemrograman Berorientasi Objek (OOP) di bahasa pemrograman Java melalui implementasi sistem Kartu Rencana Studi (KRS) sederhana. Dalam sistem ini, mahasiswa dapat menambahkan mata kuliah, menginput nilai, serta menampilkan daftar KRS yang telah diambil. Melalui praktikum ini juga dikembangkan fitur tambahan seperti hapus mata kuliah, batas maksimum SKS, dan menentukan mata kuliah terbaik serta terburuk berdasarkan nilai. Dengan penerapan konsep OOP seperti class, object, encapsulation, constructor, dan relasi antar class, praktikum ini membantu mahasiswa memahami bagaimana desain program yang modular dan efisien dapat diterapkan pada kasus nyata di lingkungan akademik.


---
## 2. Praktikum
#### Dasar Teori
Pemrograman Berorientasi Objek (Object-Oriented Programming / OOP) merupakan paradigma pemrograman yang berfokus pada pembuatan objek yang merepresentasikan entitas dunia nyata. Setiap objek memiliki atribut (field) yang menggambarkan data, dan metode (method) yang menggambarkan perilaku atau fungsinya. Dalam Java, konsep OOP digunakan untuk membuat program yang terstruktur, modular, dan mudah dipelihara.

Beberapa pilar utama OOP yang diterapkan dalam praktikum ini adalah encapsulation, constructor, dan relasi antar class. Encapsulation berfungsi melindungi data dengan menjadikannya bersifat private dan hanya dapat diakses melalui method getter atau setter. Constructor adalah method khusus yang dipanggil saat objek dibuat untuk menginisialisasi nilai awal atribut. Selain itu, relasi antar class juga menjadi bagian penting, di mana satu class dapat berinteraksi dengan class lain — misalnya class KartuRencanaStudi yang menyimpan referensi ke objek Mahasiswa dan beberapa objek Matakuliah.

Konsep lain yang penting adalah array of objects, yang digunakan untuk menampung banyak objek Matakuliah dalam class KartuRencanaStudi. Program juga menggunakan struktur kontrol seperti loop dan conditional statements untuk mengatur logika dalam menambah, mencari, dan menampilkan data. Dengan memahami teori ini, mahasiswa dapat memahami bagaimana sistem akademik sederhana seperti KRS dapat diimplementasikan dalam bentuk program Java yang berbasis objek.

#### Langkah Praktikum
1. Membuat package modul_4 untuk menampung seluruh class agar lebih terorganisir.
####
2. Membuat class Mahasiswa yang berisi atribut nama, nim, dan jurusan, lengkap dengan constructor dan getter method.
```declarative
package modul_4;

public class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;
    private double ipk;

    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    public double getIpk() {
        return ipk;
    }
}
```
3. Membuat class Matakuliah yang menyimpan data kode, nama, sks, dan nilai, serta menyediakan method untuk menampilkan informasi dan menghitung bobot nilai.
```declarative
package modul_4;

public class MataKuliah {
    private String kode;
    private String nama;
    private int sks;
    private double nilai;

    public MataKuliah(String kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.nilai = 0.0;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getSks() {
        return sks;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }
}
```
4. Membuat class KartuRencanaStudi yang berfungsi menyimpan daftar mata kuliah dalam array, menghitung total SKS, menampilkan KRS, serta mencari dan menambah mata kuliah.
```declarative
package modul_4;

public class KartuRencanaStudi {
    private Mahasiswa mahasiswa;
    private MataKuliah[] daftarMatakuliah;
    private int jumlahMatkul;
    private int maxMatkul;
    private int batasSks;

    public KartuRencanaStudi(Mahasiswa mahasiswa, int maxMatkul, int batasSks) {
        this.mahasiswa = mahasiswa;
        this.maxMatkul = maxMatkul;
        this.batasSks = batasSks;
        this.daftarMatakuliah = new MataKuliah[maxMatkul];
        this.jumlahMatkul = 0;
    }

    // Hitung total SKS
    public int totalSks() {
        int total = 0;
        for (int i = 0; i < jumlahMatkul; i++) {
            total += daftarMatakuliah[i].getSks();
        }
        return total;
    }

    // Tambah mata kuliah dengan validasi batas SKS
    public void tambahMatakuliah(MataKuliah mk) {
        if (jumlahMatkul >= maxMatkul) {
            System.out.println("KRS sudah penuh!");
            return;
        }

        if (totalSks() + mk.getSks() > batasSks) {
            System.out.println("Tidak dapat menambah mata kuliah. Total SKS melebihi batas " + batasSks + "!");
            return;
        }

        daftarMatakuliah[jumlahMatkul] = mk;
        jumlahMatkul++;
        System.out.println("Mata kuliah " + mk.getNama() + " berhasil ditambahkan!");
    }

    // Hapus mata kuliah berdasarkan kode
    public void hapusMatakuliah(String kode) {
        boolean found = false;
        for (int i = 0; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getKode().equalsIgnoreCase(kode)) {
                found = true;
                // Geser elemen setelahnya ke kiri
                for (int j = i; j < jumlahMatkul - 1; j++) {
                    daftarMatakuliah[j] = daftarMatakuliah[j + 1];
                }
                jumlahMatkul--;
                System.out.println("Mata kuliah dengan kode " + kode + " berhasil dihapus!");
                break;
            }
        }
        if (!found) {
            System.out.println("Mata kuliah dengan kode " + kode + " tidak ditemukan!");
        }
    }

    // Input nilai ke salah satu mata kuliah
    public void inputNilai(String kode, double nilai) {
        for (int i = 0; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getKode().equalsIgnoreCase(kode)) {
                daftarMatakuliah[i].setNilai(nilai);
                System.out.println("Nilai berhasil dimasukkan untuk mata kuliah " + daftarMatakuliah[i].getNama());
                return;
            }
        }
        System.out.println("Mata kuliah tidak ditemukan!");
    }

    // Tampilkan daftar KRS
    public void tampilkanKRS() {
        System.out.println("\n================== DAFTAR KRS ==================");
        System.out.println("Nama Mahasiswa : " + mahasiswa.getNama());
        System.out.println("NIM            : " + mahasiswa.getNim());
        System.out.println("Jurusan        : " + mahasiswa.getJurusan());
        System.out.println("-----------------------------------------------");

        if (jumlahMatkul == 0) {
            System.out.println("Belum ada mata kuliah yang diambil.");
            return;
        }

        for (int i = 0; i < jumlahMatkul; i++) {
            MataKuliah mk = daftarMatakuliah[i];
            System.out.println((i + 1) + ". " + mk.getKode() + " - " + mk.getNama() +
                    " (" + mk.getSks() + " SKS) | Nilai: " + mk.getNilai());
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Total SKS: " + totalSks());
    }

    // Cari mata kuliah dengan nilai terbaik dan terburuk
    public void tampilkanTerbaikDanTerburuk() {
        if (jumlahMatkul == 0) {
            System.out.println("Belum ada mata kuliah dalam KRS.");
            return;
        }

        MataKuliah terbaik = daftarMatakuliah[0];
        MataKuliah terburuk = daftarMatakuliah[0];

        for (int i = 1; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getNilai() > terbaik.getNilai()) {
                terbaik = daftarMatakuliah[i];
            }
            if (daftarMatakuliah[i].getNilai() < terburuk.getNilai()) {
                terburuk = daftarMatakuliah[i];
            }
        }

        System.out.println("\n================= NILAI TERBAIK & TERBURUK =================");
        System.out.println("Mata Kuliah Terbaik : " + terbaik.getNama() + " (" + terbaik.getNilai() + ")");
        System.out.println("Mata Kuliah Terburuk: " + terburuk.getNama() + " (" + terburuk.getNilai() + ")");
    }
}
```
5. Membuat class Main sebagai titik awal eksekusi program yang menampilkan menu interaktif kepada pengguna untuk melakukan input data mahasiswa dan manipulasi data KRS.
```declarative
package modul_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("------------------------------------------------");
        System.out.println("           SISTEM KARTU RENCANA STUDI (KRS)     ");
        System.out.println("------------------------------------------------");

        // Input data mahasiswa
        System.out.print("Nama Mahasiswa: ");
        String nama = input.nextLine();

        System.out.print("NIM: ");
        String nim = input.nextLine();

        System.out.print("Jurusan: ");
        String jurusan = input.nextLine();

        // Membuat object mahasiswa
        Mahasiswa mhs = new Mahasiswa(nama, nim, jurusan, 0.0);

        // Membuat object KRS (maksimal 10 mata kuliah, batas SKS = 24)
        KartuRencanaStudi krs = new KartuRencanaStudi(mhs, 10, 24);

        boolean running = true;

        while (running) {
            System.out.println("------------------------------------------------");
            System.out.println("|                  MENU KRS                    |");
            System.out.println("------------------------------------------------");
            System.out.println("| 1. Tambah Mata Kuliah                        |");
            System.out.println("| 2. Input Nilai Mata Kuliah                   |");
            System.out.println("| 3. Hapus Mata Kuliah                         |");
            System.out.println("| 4. Tampilkan KRS                             |");
            System.out.println("| 5. Tampilkan Nilai Terbaik & Terburuk        |");
            System.out.println("| 6. Keluar                                    |");
            System.out.println("------------------------------------------------");
            System.out.print("Pilih menu: ");

            int pilihan = input.nextInt();
            input.nextLine(); // consume newline

            switch (pilihan) {
                case 1:
                    // Tambah mata kuliah
                    System.out.println("\nTAMBAH MATA KULIAH");
                    System.out.println("--------------------");
                    System.out.print("Kode Mata Kuliah: ");
                    String kode = input.nextLine();

                    System.out.print("Nama Mata Kuliah: ");
                    String namaMK = input.nextLine();

                    System.out.print("Jumlah SKS: ");
                    int sks = input.nextInt();
                    input.nextLine();

                    MataKuliah mk = new MataKuliah(kode, namaMK, sks);
                    krs.tambahMatakuliah(mk);
                    break;

                case 2:
                    // Input nilai
                    System.out.println("\nINPUT NILAI");
                    System.out.println("--------------------");
                    System.out.print("Masukkan kode mata kuliah: ");
                    String kodeNilai = input.nextLine();
                    System.out.print("Masukkan nilai (0-100): ");
                    double nilai = input.nextDouble();
                    input.nextLine();
                    krs.inputNilai(kodeNilai, nilai);
                    break;

                case 3:
                    // Hapus mata kuliah
                    System.out.println("\nHAPUS MATA KULIAH");
                    System.out.println("--------------------");
                    System.out.print("Masukkan kode mata kuliah yang ingin dihapus: ");
                    String kodeHapus = input.nextLine();
                    krs.hapusMatakuliah(kodeHapus);
                    break;

                case 4:
                    // Tampilkan KRS
                    krs.tampilkanKRS();
                    break;

                case 5:
                    // Tampilkan terbaik & terburuk
                    krs.tampilkanTerbaikDanTerburuk();
                    break;

                case 6:
                    running = false;
                    System.out.println("Keluar dari program...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }
        input.close();
    }
}
```
6. Melakukan uji coba program untuk memastikan setiap fitur berjalan dengan benar dan menghasilkan output sesuai harapan.
#### Screenshoot Hasil

#### Analisa dan Pembahasan

---
## 3. Kesimpulan

---

## 4. Referensi
Cantumkan sumber yang Anda baca (buku, artikel, dokumentasi) — minimal 2 sumber. Gunakan format sederhana (judul — URL).

---
