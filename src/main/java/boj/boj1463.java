package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1463 {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        topDown(n, 0);
        System.out.println(answer);
    }

    private static void topDown(int n, int count) {
        if(n==1) {
            answer = Math.min(answer, count);
            return;
        }

        if(count >= answer) {
            return;
        }

        if(n%3==0) {
            topDown(n/3, count+1);
        }

        if(n%2==0) {
            topDown(n/2, count+1);
        }

        topDown(n-1, count+1);
    }
}
