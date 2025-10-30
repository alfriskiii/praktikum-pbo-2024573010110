package latihan_3;

import java.util.Scanner;

public class NilaiMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] nilai = new int[5];
        String[] nama = new String[5];

        for (int i = 0; i < nilai.length; i++) {
            System.out.print("Masukkan nama mahasiswa ke-" + (i + 1) + ": ");
            nama[i] = input.nextLine();

            int n;
            do {
                System.out.print("Masukkan nilai mahasiswa ke-" + (i + 1) + ": ");
                n = input.nextInt();
                input.nextLine();
                if (n < 0 || n > 100)
                    System.out.println("Nilai harus antara 0–100!");
            } while (n < 0 || n > 100);

            nilai[i] = n;
        }

        System.out.println("\nDaftar Nilai Mahasiswa:");
        for (int i = 0; i < nilai.length; i++) {
            System.out.println(nama[i] + " = " + nilai[i]);
        }

        int total = 0;
        for (int n : nilai) total += n;
        double rata = (double) total / nilai.length;

        int max = nilai[0], min = nilai[0];
        String nmMax = nama[0], nmMin = nama[0];
        for (int i = 1; i < nilai.length; i++) {
            if (nilai[i] > max) {
                max = nilai[i];
                nmMax = nama[i];
            }
            if (nilai[i] < min) {
                min = nilai[i];
                nmMin = nama[i];
            }
        }

        System.out.println("\nRata-rata nilai = " + rata);
        System.out.println("Nilai tertinggi: " + nmMax + " (" + max + ")");
        System.out.println("Nilai terendah : " + nmMin + " (" + min + ")");
    }
}

