package latihan_3;

public class KalkulatorMethod {

    public static void tampilHeader() {
        System.out.println("=======================");
        System.out.println("   PROGRAM KALKULATOR   ");
        System.out.println("=======================");
    }

    public static double tambah(double a, double b) { return a + b; }
    public static double kurang(double a, double b) { return a - b; }
    public static double kali(double a, double b) { return a * b; }
    public static double bagi(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Pembagian dengan nol!");
            return 0;
        } else return a / b;
    }
    public static double pangkat(double a, double b) { return Math.pow(a, b); }

    public static boolean validasiInput(double n) {
        return n >= 0 && !Double.isNaN(n);
    }

    public static void main(String[] args) {
        tampilHeader();
        double x = 5, y = 2;

        if (validasiInput(x) && validasiInput(y)) {
            System.out.println("Hasil Penjumlahan: " + tambah(x, y));
            System.out.println("Hasil Pengurangan: " + kurang(x, y));
            System.out.println("Hasil Perkalian  : " + kali(x, y));
            System.out.println("Hasil Pembagian  : " + bagi(x, y));
            System.out.println("Hasil Pangkat    : " + pangkat(x, y));
        } else {
            System.out.println("Input tidak valid!");
        }
    }
}

