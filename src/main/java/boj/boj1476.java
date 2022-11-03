package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // e : 1 ~ 15
        int E = Integer.parseInt(st.nextToken());

        // s : 1 ~ 28
        int S = Integer.parseInt(st.nextToken());

        // m : 1 ~ 19
        int M = Integer.parseInt(st.nextToken());

        int e = 1;
        int s = 1;
        int m = 1;
        int answer = 1;
        while(true) {
            if(e==E && s==S && m==M) {
                break;
            }
            e++;
            s++;
            m++;
            answer++;
            if(e>15) {
                e=1;
            }
            if(s>28) {
                s=1;
            }
            if(m>19) {
                m=1;
            }
        }
        System.out.println(answer);

    }
}
