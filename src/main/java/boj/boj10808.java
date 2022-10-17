package boj;

import java.util.Scanner;

public class boj10808 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[26];
        String str = scanner.nextLine();
        //a-97
        for(int i=0;i<str.length();i++) {
            Character c = str.charAt(i);
            int index = c*1 - 97;
            arr[index]++;
        }
        for(int i=0;i<26;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
