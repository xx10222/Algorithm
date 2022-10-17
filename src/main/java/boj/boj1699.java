package boj;

import java.util.Scanner;

public class boj1699 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<=n;i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j=1;j<=i/2;j++) {
                if(j*j==i) {
                    dp[i]=1;
                    break;
                }
                dp[i] = Math.min(dp[i], dp[j]+dp[i-j]);
            }
        }
        System.out.println(dp[n]);
    }
}
