package boj;

import java.util.Scanner;

public class boj10824 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(" ");

        long num1 = Long.parseLong(arr[0]+arr[1]);
        long num2 = Long.parseLong(arr[2]+arr[3]);
        System.out.println(num1+num2);
    }
}
