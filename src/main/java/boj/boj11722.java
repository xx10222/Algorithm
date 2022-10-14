package boj;

import java.util.Scanner;

public class boj11722 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }

        int answer = 0;
        for(int i=n-1;i>=0;i--) {
            dp[i] = 1;
            for(int j=n-1;j>i;j--) {
                if(arr[i]>arr[j] && dp[i]<dp[j]+1) {
                    dp[i] = dp[j]+1;
                }
            }
            if(answer<dp[i]) {
                answer = dp[i];
            }
        }
        System.out.println(answer);
    }
}
