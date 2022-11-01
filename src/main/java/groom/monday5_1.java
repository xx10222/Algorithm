package groom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class monday5_1 {
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int answer = 0;
        arr = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                arr[i][j] = scanner.nextInt();
                if(arr[i][j]==1) {
                    answer++; // 현재 개미집 개수
                }
            }
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(arr[i][j]==1) {
                    visit = new boolean[n+1][n+1];
                    System.out.println('\n'+"bfs");
                    if(!bfs(n, m, i, j)) {
                        answer--;
                    }
                }
            }
        }
        System.out.println(answer);

    }

    private static boolean bfs(int n, int m, int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0}; //상 하 좌 우
        int[] dy = {0, 0, -1, 1};
        int depth=0;
        q.add(x);
        q.add(y);
        q.add(depth);

        while(!q.isEmpty()) {
            System.out.println("depth = " + depth);
            int nextX = q.poll();
            int nextY = q.poll();
            int count = q.poll();

            if(count==m) {
                return false;
            }

            System.out.println("nextX=" + nextX+" nextY=" + nextY);

            for(int i=0;i<4;i++) {
                int nx = nextX+dx[i];
                int ny = nextY+dy[i];
                if(nx>0&&nx<=n&&ny>0&&ny<=n) {
                    System.out.println("("+nx+","+ny+")");
                    if(arr[nx][ny]==2) {
                        System.out.println("hello bug!");
                        return true;
                    }
                    q.add(nx);
                    q.add(ny);
                    q.add(count+1);
                }

            }
        }
        return false;
    }
}
