package groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class monday1_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] arr = new int[n+1];
        String s = br.readLine();
        String[] str= s.split(" ");
        for(int i=0;i<n;i++) {
            arr[i+1] = Integer.parseInt(str[i]);
        }
        for(int i=1;i<=n;i++) {
            if(isPrime(i)) {
                answer += arr[i];
            }
        }
        System.out.println(answer);
    }

    private static boolean isPrime(int n) {
        if(n==1) {
            return false;
        }

        for(int i=2;i*i<=n;i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
}
