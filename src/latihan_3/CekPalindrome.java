package latihan_3;

import java.util.Scanner;

public class CekPalindrome {

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("\\s+", "").toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static int hitungVokal(String s) {
        int count = 0;
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) != -1)
                count++;
        }
        return count;
    }

    public static int hitungKonsonan(String s) {
        int count = 0;
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z' && "aeiou".indexOf(c) == -1)
                count++;
        }
        return count;
    }

    public static String balikKalimat(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan kalimat: ");
        String kalimat = input.nextLine();

        System.out.println("Palindrome: " + isPalindrome(kalimat));
        System.out.println("Jumlah huruf vokal: " + hitungVokal(kalimat));
        System.out.println("Jumlah huruf konsonan: " + hitungKonsonan(kalimat));
        System.out.println("Kalimat dibalik: " + balikKalimat(kalimat));
    }
}
