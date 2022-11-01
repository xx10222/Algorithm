package groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class monday1_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int n = Integer.parseInt(st.nextToken());
        String name = st.nextToken();

        for(int i=0;i<n;i++) {
            String s = br.readLine();
            if(s.contains(name)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
