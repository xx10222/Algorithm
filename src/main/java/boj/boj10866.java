package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int num;
        for(int i=0;i<n;i++) {
            String[] arr = br.readLine().split(" ");
            String s = arr[0];
            switch (s) {
                case "push_front":
                    num = Integer.parseInt(arr[1]);
                    deque.addFirst(num);
                    break;

                case "push_back":
                    num = Integer.parseInt(arr[1]);
                    deque.addLast(num);
                    break;

                case "pop_front":
                    if(deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.removeFirst()).append('\n');
                    }
                    break;

                case "pop_back":
                    if(deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.pollLast()).append('\n');
                    }
                    break;

                case "size":
                    sb.append(deque.size()).append('\n');
                    break;

                case "empty":
                    if(deque.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;

                case "front":
                    if(deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.peekFirst()).append('\n');
                    }
                    break;

                case "back":
                    if(deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.peekLast()).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
