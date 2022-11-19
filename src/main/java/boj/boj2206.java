package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2206 {
    static boolean[][][] visit;
    static int[][] arr;
    static int answer;

    static class Point {
        int x;
        int y;
        int crash; //벽 부순 여부
        int count; //이동 거리

        public Point(int x, int y, int crash, int count) {
            this.x = x;
            this.y = y;
            this.crash = crash;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 출발지와 도착지가 같은 경우
        if (n - 1 == 0 && m - 1 == 0) {
            System.out.println(1);
            return;
        }

        // visit[x][y][0] : 아직 벽을 부수지 않은 경우
        // visit[x][y][1] : 이미 벽을 부순 경우
        visit = new boolean[n][m][2];
        arr = new int[n][m];

        // map 초기 설정
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        answer = Integer.MAX_VALUE; // 답 초기 설정
        bfs(0, 0, n, m); //(0,0)에서 출발

        if (answer == Integer.MAX_VALUE) { //도착지에 갈 수 없는 경우
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void bfs(int x, int y, int n, int m) {
        int[] dx = {1, -1, 0, 0}; //상 하 좌 우
        int[] dy = {0, 0, -1, 1};

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0, 1)); //이동거리가 1인 이유 - 문제 조건에 시작하는 칸도 포함하여 거리를 센다고 함
        visit[0][0][0] = true; //출발지 방문 체크

        while (!q.isEmpty()) {
            Point p = q.poll();

            // 만약 목적지에 도착하면, 지금까지의 이동거리와 answer를 비교해서 최솟값으로 업데이트
            if (p.x == n - 1 && p.y == m - 1) {
                answer = Math.min(answer, p.count);
                continue;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // 범위 확인
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 이미 방문한 경우 탐색 X
                    if (visit[nx][ny][p.crash]) {
                        continue;
                    }

                    // 벽이 아닌 경우
                    if (arr[nx][ny] == 0) {
                        visit[nx][ny][p.crash] = true;
                        q.add(new Point(nx, ny, p.crash, p.count + 1));
                    } else if (arr[nx][ny] == 1 && p.crash == 0) { //현재 벽인데, 아직 벽을 부순 적이 없는 경우
                        visit[nx][ny][1] = true;
                        q.add(new Point(nx, ny, 1, p.count + 1));
                    }
                }
            }
        }
    }
}
