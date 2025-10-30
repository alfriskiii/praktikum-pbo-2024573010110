package latihan_3;

import java.util.Scanner;

public class OperasiArray {

    public static void inputArray(int[][] array) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print("Masukkan nilai [" + i + "][" + j + "]: ");
                array[i][j] = sc.nextInt();
            }
        }
    }

    public static void outputArray(int[][] array) {
        for (int[] baris : array) {
            for (int nilai : baris) {
                System.out.print(nilai + "\t");
            }
            System.out.println();
        }
    }

    public static int jumlahkanArray(int[][] array) {
        int total = 0;
        for (int[] baris : array)
            for (int nilai : baris)
                total += nilai;
        return total;
    }

    public static double rataRataArray(int[][] array) {
        int total = jumlahkanArray(array);
        return (double) total / (array.length * array[0].length);
    }

    public static int cariNilaiMax(int[][] array) {
        int max = array[0][0];
        for (int[] baris : array)
            for (int nilai : baris)
                if (nilai > max)
                    max = nilai;
        return max;
    }

    public static int cariNilaiMin(int[][] array) {
        int min = array[0][0];
        for (int[] baris : array)
            for (int nilai : baris)
                if (nilai < min)
                    min = nilai;
        return min;
    }

    public static void cariNilai(int[][] array, int target) {
        boolean ketemu = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == target) {
                    System.out.println("Nilai ditemukan di posisi [" + i + "][" + j + "]");
                    ketemu = true;
                }
            }
        }
        if (!ketemu)
            System.out.println("Nilai tidak ditemukan dalam array.");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah baris: ");
        int baris = input.nextInt();
        System.out.print("Masukkan jumlah kolom: ");
        int kolom = input.nextInt();

        int[][] data = new int[baris][kolom];
        inputArray(data);

        System.out.println("\nIsi array:");
        outputArray(data);

        System.out.println("\nJumlah seluruh elemen: " + jumlahkanArray(data));
        System.out.println("Rata-rata elemen: " + rataRataArray(data));
        System.out.println("Nilai maksimum: " + cariNilaiMax(data));
        System.out.println("Nilai minimum: " + cariNilaiMin(data));

        System.out.print("\nMasukkan nilai yang ingin dicari: ");
        int cari = input.nextInt();
        cariNilai(data, cari);
    }
}

