package boj;

import java.util.Scanner;

public class boj2193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] dp = new long[n+1][2];

        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i=2;i<=n;i++) {
            for(int j=0;j<2;j++) {
                if(j==0) {
                    dp[i][j] = dp[i-1][0] + dp[i-1][1];
                } else {
                    dp[i][j] = dp[i-1][0];
                }
            }
        }

        System.out.println(dp[n][0]+dp[n][1]);

    }
}
