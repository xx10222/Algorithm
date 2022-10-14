package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int last=0;
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            switch (s) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    last = num;
                    queue.offer(num);
                    break;

                case "pop":
                    if(queue.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(queue.poll());
                    }
                    sb.append("\n");
                    break;

                case "size":
                    sb.append(queue.size()).append('\n');
                    break;

                case "empty":
                    if(queue.isEmpty()) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                    sb.append('\n');
                    break;

                case "front":
                    if(queue.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(queue.peek());
                    }
                    sb.append('\n');
                    break;

                case "back":
                    if(queue.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(last);
                    }
                    sb.append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
