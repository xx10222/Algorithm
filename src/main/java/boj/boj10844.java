package boj;

import java.util.Scanner;

public class boj10844 {
    static long mod = 1000000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] dp = new long[n+1][10]; //dp[i][j] - 길이가 i이고, j로 끝나는 계단수의 갯수

        for(int j=1;j<10;j++) { // 길이가 1인 계단수
            dp[1][j] = 1;
        }

        for(int i=2;i<=n;i++) {
            for(int j=0;j<10;j++) {
                if(j==0) {
                    dp[i][0] = dp[i-1][1] % mod;
                } else if(j==9) {
                    dp[i][9] = dp[i-1][8] % mod;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
            }
        }

        long answer = 0;
        for(int j=0;j<10;j++) {
            answer += dp[n][j];
        }

        System.out.println(answer%mod);


    }
}
