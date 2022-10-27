package programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class 가장먼노드 {
    static ArrayList<Integer>[] list;
    static int[] visit;
    static int max;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        visit = new int[n+1];
        list = new ArrayList[n+1];
        for(int i=0;i<=n;i++) {
            list[i] = new ArrayList<>();
        }

        //그래프 간선 설정
        for(int[] e : edge) {
            int x = e[0];
            int y = e[1];
            list[x].add(y);
            list[y].add(x);
        }

        max = 0;
        bfs(1,0);
        
        for(int i=2;i<=n;i++) {
            if(max==visit[i]) {
                answer++;
            }
        }
       return answer;
    }

    private static void bfs(int start, int count) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        q.add(count);
        visit[start] = count;

        while (!q.isEmpty()) {
            int node = q.poll();
            int depth = q.poll();
            if(max<depth) {
                max=depth;
            }
            for(int i=0;i<list[node].size();i++) {
                int next = list[node].get(i);
                if(visit[next]==0) {
                    visit[next] = depth+1;
                    q.add(next);
                    q.add(depth+1);
                }
            }
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(3, solution(6, new int[][] {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}}));
    }
}
