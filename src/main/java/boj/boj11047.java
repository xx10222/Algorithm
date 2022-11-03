package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] money = new int[n];
        for(int i=0;i<n;i++) {
            money[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for(int i=n-1;i>=0;i--) {
            if(k<=0) {
                break;
            }
            count += (k/money[i]);
            k %= money[i];
        }
        System.out.println(count);
    }
}
