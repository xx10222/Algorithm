package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //k칸씩 이동하면서 삭제
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            q.offer(i);
        }
        List<Integer> list = new ArrayList<>();
        int count = 1;
        while(!q.isEmpty()) {
            int num = q.poll();
            if(count!=k) {
                q.offer(num);
                count++;
                continue;
            }
            list.add(num+1);
            count=1;
        }
        sb.append("<");
        for(int i=0;i<list.size()-1;i++) {
            sb.append(list.get(i));
            sb.append(", ");
        }
        sb.append(list.get(list.size()-1));
        sb.append(">");
        System.out.println(sb);
    }
}
