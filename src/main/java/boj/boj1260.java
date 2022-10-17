package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1260 {
    static boolean[] visit;
    static int[][] arr;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        int v = scanner.nextInt(); //탐색 시작 인덱스

        arr = new int[n+1][n+1];

        for(int i=0;i<m;i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arr[x][y]=arr[y][x]=1;
        }

        visit = new boolean[n+1];
        dfs(v);
        System.out.println();
        visit = new boolean[n+1];
        bfs(v);

    }

    private static void dfs(int v) {
        visit[v] = true;
        System.out.print(v + " ");
        for(int i=1;i<=n;i++) {
            if(!visit[i] && arr[v][i]==1) {
                dfs(i);
            }
        }
        return;
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
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
