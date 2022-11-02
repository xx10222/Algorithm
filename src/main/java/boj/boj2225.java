package boj;

import java.util.Scanner;

public class boj2225 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        // dp[k][n] : k개의 정수로 n을 만드는 경우의 수
        int[][] dp = new int[k+1][n+1];

        // 1개로 n을 만드는 경우의 수는 무조건 1개이다
        for(int i=0;i<=n;i++) {
            dp[1][i] = 1;
        }

        //dp[k][n] = dp[k-1][n] + dp[k-1][n-1] + dp[k-1][n-2] + .. + dp[k-1][0]
        for(int i=1;i<=k;i++) {
            for(int j=0;j<=n;j++) {
                for(int a=0;a<=j;a++) {
                    dp[i][j] += dp[i-1][j-a];
                    dp[i][j] %= 1000000000;
                }
            }
        }
        System.out.println(dp[k][n]);
    }
}
