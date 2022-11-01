package groom;

import java.math.BigInteger;
import java.util.Scanner;

public class monday1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        BigInteger answer = BigInteger.ONE;
        for(int i=0;i<n;i++) {
            answer = answer.multiply(BigInteger.valueOf(arr[i]));
        }
        System.out.println(answer);

    }
}
