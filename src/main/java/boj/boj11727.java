package boj;

import java.util.Scanner;

public class boj11727 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n+2];

        dp[0]=0;
        dp[1]=1;
        dp[2]=3;

        for(int i=3;i<=n;i++) {
            dp[i] = ((2*dp[i-2]) + dp[i-1])%10007;
        }
        System.out.println(dp[n]%10007);
    }
}
