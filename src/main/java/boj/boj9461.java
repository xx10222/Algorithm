package boj;

import java.util.Scanner;

public class boj9461 {
    static long[] dp = new long[101];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;

        for(int i=0;i<t;i++) {
            int n = scanner.nextInt();
            System.out.println(padovan(n));
        }
    }

    private static long padovan(int n) {
        if(dp[n] == 0 && n!=0) {
            dp[n] = padovan(n-2) + padovan(n-3);
        }
        return dp[n];
    }
}
