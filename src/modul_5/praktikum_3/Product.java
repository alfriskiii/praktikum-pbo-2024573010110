package modul_5.praktikum_3;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Product {
    private String productId;
    private String nama;
    private double harga;
    private int stok;
    private Date createdAt;

    // Constructor
    public Product(String nama, double harga, int stok) {
        this.productId = "P" + System.currentTimeMillis();
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.createdAt = new Date();
    }

    // Getter
    public String getProductId() {
        return productId;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public String getCreatedAt() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdf.format(createdAt);
    }

    public double getTotalNilai() {
        return harga * stok;
    }

    public String getStatusStok() {
        if (stok == 0) {
            return "Habis";
        } else if (stok < 10) {
            return "Menipis";
        } else {
            return "Tersedia";
        }
    }

    // Tambah stok
    public boolean tambahStok(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("✖ Jumlah harus lebih dari 0!");
            return false;
        }

        stok += jumlah;
        System.out.printf("✔ Stok ditambah %d. Stok sekarang: %d%n", jumlah, stok);
        return true;
    }

    // Kurangi stok
    public boolean kurangiStok(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("✖ Jumlah harus lebih dari 0!");
            return false;
        }

        if (jumlah > stok) {
            System.out.println("✖ Stok tidak cukup!");
            System.out.printf("   Stok tersedia: %d, Diminta: %d%n", stok, jumlah);
            return false;
        }

        stok -= jumlah;
        System.out.printf("✔ Stok dikurangi %d. Stok sekarang: %d%n", jumlah, stok);

        // Warning jika stok menipis
        if (stok < 10) {
            System.out.println("⚠️ Peringatan: Stok menipis!");
        }

        return true;
    }

    // Tampilkan informasi produk
    public void tampilkanInfo() {
        System.out.println("======================================");
        System.out.println("          INFORMASI PRODUK");
        System.out.println("======================================");
        System.out.println("Product ID   : " + productId);
        System.out.println("Nama         : " + nama);
        System.out.printf("Harga        : Rp %.2f%n", harga);
        System.out.printf("Stok         : %d (%s)%n", stok, getStatusStok());
        System.out.printf("Total Nilai  : Rp %.2f%n", getTotalNilai());
        System.out.println("Dibuat pada  : " + getCreatedAt());
        System.out.println("======================================\n");
    }
}