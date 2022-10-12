package groom;

import java.util.Scanner;

public class monday1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 1;
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
//            arr[i] = scanner.nextInt();
            answer *= scanner.nextInt();
        }
        System.out.println(answer);

    }
}
