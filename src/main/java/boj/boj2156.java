package boj;

import java.util.Scanner;

public class boj2156 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }

        dp[0] = arr[0];
        for(int i=1;i<n;i++) {
            if (i == 1) {
                dp[1] = arr[0]+arr[1];
                continue;
            }
            if(i==2) {
                dp[2] = Math.max(dp[1], Math.max(arr[1]+arr[2], arr[0]+arr[2]));
                continue;
            }
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]));
        }
        System.out.println(dp[n-1]);
    }
}
