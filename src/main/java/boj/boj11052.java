package boj;

import java.util.Scanner;

public class boj11052 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++) {
            arr[i] = scanner.nextInt();
        }

        dp[0] = 0;
        dp[1] = arr[1];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
            }
        }

        System.out.println(dp[n]);

    }
}
