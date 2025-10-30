package latihan_3;

import java.util.Scanner;

public class NilaiMatriks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] nilai = new int[4][3];

        for (int i = 0; i < nilai.length; i++) {
            for (int j = 0; j < nilai[0].length; j++) {
                System.out.print("Masukkan nilai mahasiswa ke-" + (i + 1) +
                        ", mata kuliah ke-" + (j + 1) + ": ");
                nilai[i][j] = input.nextInt();
            }
        }

        System.out.println("\nTabel Nilai:");
        for (int i = 0; i < nilai.length; i++) {
            System.out.print("Mahasiswa " + (i + 1) + ": ");
            for (int j = 0; j < nilai[0].length; j++) {
                System.out.print(nilai[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nRata-rata tiap mahasiswa:");
        for (int i = 0; i < nilai.length; i++) {
            int total = 0;
            for (int j = 0; j < nilai[0].length; j++) total += nilai[i][j];
            System.out.println("Mahasiswa " + (i + 1) + ": " + (total / 3.0));
        }

        System.out.println("\nNilai tertinggi tiap mata kuliah:");
        for (int j = 0; j < nilai[0].length; j++) {
            int max = nilai[0][j];
            for (int i = 1; i < nilai.length; i++) {
                if (nilai[i][j] > max) max = nilai[i][j];
            }
            System.out.println("Mata kuliah " + (j + 1) + ": " + max);
        }

        System.out.print("\nCari nilai mahasiswa ke berapa: ");
        int mhs = input.nextInt() - 1;
        System.out.print("Mata kuliah ke berapa: ");
        int mk = input.nextInt() - 1;
        System.out.println("Nilai = " + nilai[mhs][mk]);
    }
}

