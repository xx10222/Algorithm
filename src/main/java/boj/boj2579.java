package boj;

import java.util.Scanner;

public class boj2579 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] dp = new int[n+1];
        int[] arr = new int[n+1];

        for(int i=1;i<=n;i++) {
            arr[i] = scanner.nextInt();
        }

        dp[1] = arr[1];
        dp[2] = arr[1]+arr[2];
        dp[3] = Math.max(arr[1], arr[2]) + arr[3];

        for(int i=4;i<=n;i++) {
            dp[i] = Math.max(dp[i-3]+arr[i-1], dp[i-2]) + arr[i];
        }

        System.out.println(dp[n]);
    }
}
