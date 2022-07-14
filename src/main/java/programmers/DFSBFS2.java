package programmers;

import org.junit.Assert;
import org.junit.Test;

public class DFSBFS2 {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                dfs(computers, i);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int[][] computers, int x) {
        visited[x] = true;

        for(int i=0;i<computers.length;i++) {
            if(i!=x && computers[x][i]==1 && !visited[i]) {
                dfs(computers, i);
            }
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(2, solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        Assert.assertEquals(1, solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}
