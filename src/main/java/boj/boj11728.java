package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int num : list) {
            sb.append(num + " ");
        }
        System.out.println(sb);

    }
}
