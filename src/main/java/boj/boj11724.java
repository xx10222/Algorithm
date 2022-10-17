package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj11724 {
    static int[][] arr;
    static boolean[] visit;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int answer = 0;
        int m = scanner.nextInt();
        arr = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int i=0;i<m;i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arr[x][y] = arr[y][x] = 1;
        }

        for(int i=1;i<=n;i++) {
            if(!visit[i]) {
                bfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            visit[now] = true;
            for(int i=1;i<=n;i++) {
                if(!visit[i] && arr[now][i]==1) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}
