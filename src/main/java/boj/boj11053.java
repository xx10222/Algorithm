package boj;

import java.util.Scanner;

public class boj11053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }

        int[] dp = new int[n];
        int answer = 0;
        for(int i=0;i<n;i++) {
            dp[i]=1;
            for(int j=0;j<i;j++) {
                if(arr[j]<arr[i] && dp[i]< dp[j]+1) {
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
