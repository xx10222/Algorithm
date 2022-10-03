package boj;

import java.util.Scanner;

public class boj9095 {
    static int[] dp = new int[12];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for(int i=4;i<=11;i++) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }

        while(t>0) {
            int n =scanner.nextInt();
            System.out.println(dp[n]);
            t--;
        }

    }
}
