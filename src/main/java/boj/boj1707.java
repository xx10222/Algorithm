package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj1707 {
    static int[] visit;
    static List<Integer>[] list;
    static int v, e;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        for(int i=0;i<k;i++) {
            v = scanner.nextInt();
            e = scanner.nextInt();
            visit = new int[v+1]; //방문(그룹) 배열 초기화
            list = new ArrayList[v+1]; //그래프 초기화

            for(int j=0;j<=v;j++) { //그래프 배열 초기화
                list[j] = new ArrayList<>();
            }

            for(int j=0;j<e;j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                list[x].add(y);
                list[y].add(x);
            }

            bfs();
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=v;i++) {
            if(visit[i]==0) {
                q.add(i);
                visit[i] = 1;
            }

            while(!q.isEmpty()) {
                int now = q.poll();
                for(int j=0;j<list[now].size();j++) {
                    if (visit[list[now].get(j)] == 0) {
                        q.add(list[now].get(j));
                    }

                    if(visit[list[now].get(j)] == visit[now]) {
                        System.out.println("NO");
                        return;
                    }

                    if(visit[now] == 1 && visit[list[now].get(j)] == 0) {
                        visit[list[now].get(j)] = 2;
                    } else if(visit[now] == 2 && visit[list[now].get(j)] == 0) {
                        visit[list[now].get(j)] = 1;
                    }
                }
            }
        }
        System.out.println("YES");
    }
}
