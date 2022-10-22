package boj;

import java.util.Scanner;

public class boj2133 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[31];
        dp[0]=1;
        dp[2]=3;
        dp[4]=11;
        for(int i=6;i<=n;i+=2) {
            dp[i] = dp[i-2] * dp[2];
            for(int j=i-4;j>=0;j-=2) {
                dp[i] += 2*dp[j];
            }
        }
        System.out.println(dp[n]);
    }
}
