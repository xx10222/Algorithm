package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10451 {
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count;
        for(int t=0;t<T;t++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visit = new boolean[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            count=0;
            for(int i=1;i<=n;i++) {
                if(!visit[i]) {
                    count++;
                    cycle(i);
                }
            }

            System.out.println(count);
        }
    }

    private static void cycle(int x) {
        visit[x] = true;
        if(!visit[arr[x]]) {
            cycle(arr[x]);
        }
    }
}
