package boj;

import java.util.Scanner;

public class boj9465 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t>0) {
            t--;
            int n = scanner.nextInt();
            int[][] arr = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            for(int i=0;i<2;i++) {
                for(int j=1;j<=n;j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for(int j=2;j<n+1;j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
