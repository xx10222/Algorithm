package programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class DivideElectronicNet {
    static boolean[] visit;
    static int[][] arr;
    public int solution(int n, int[][] wires) {
        int answer = 101;
        arr = new int[n+1][n+1];
        // 그래프 초기화
        for(int[] wire : wires) {
            int x = wire[0];
            int y = wire[1];
            arr[x][y] = arr[y][x] = 1;
        }

        // 전력망을 하나씩 끊어보면서 각각의 송전탑 개수 구하기
        int diff = 0;
        for(int[] wire : wires) {
            int x = wire[0];
            int y = wire[1];
            visit = new boolean[n+1];
            arr[x][y] = arr[y][x] = 0;
            diff = 0;
            for(int i=1;i<=n;i++) {
                if(!visit[i]) {
                    int count = bfs(i, n);
                    diff = Math.abs(diff-count);
                }
            }
            // 최솟값으로 업데이트
            if(answer > diff) {
                answer = diff;
            }
            arr[x][y] = arr[y][x] = 1;
        }

        return answer;
    }

    private static int bfs(int start, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int count = 1;
        while(!q.isEmpty()) {
            int next = q.poll();
            visit[next] = true;
            for(int i=1;i<=n;i++) {
                if(arr[next][i]==1 && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, solution(9, new int[][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
        Assert.assertEquals(0, solution(4, new int[][] {{1,2},{2,3},{3,4}}));
        Assert.assertEquals(1, solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));
    }
}
