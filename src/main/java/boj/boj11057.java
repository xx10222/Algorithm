package boj;

import java.util.Scanner;

public class boj11057 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] dp = new int[n+1][10];

        for(int j=0;j<10;j++) {
            dp[1][j] = 1;
        }

        for(int i=2;i<=n;i++) {
            for(int j=0;j<10;j++) {
                for(int k=0;k<=j;k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        int answer = 0;
        for(int i=0;i<10;i++) {
            answer = (answer+dp[n][i])%10007;
        }
        System.out.println(answer%10007);

    }
}
