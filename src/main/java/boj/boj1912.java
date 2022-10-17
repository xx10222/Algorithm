package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj1912 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            list.add(scanner.nextInt());
        }

        // 연속된 수들의 합 중 가장 큰 값
        dp[0] = list.get(0);
        int answer = list.get(0);
        for(int i=1;i<n;i++) {
            dp[i] = Math.max(dp[i-1]+list.get(i), list.get(i));
            if(answer<dp[i]) {
                answer = dp[i];
            }
        }
        System.out.println(answer);
    }
}
