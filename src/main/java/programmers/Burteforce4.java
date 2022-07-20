package programmers;

import org.junit.Assert;
import org.junit.Test;

public class Burteforce4 {
    static boolean[] visited;
    static int answer=0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        return answer;
    }

    public static void dfs(int[][] dungenos, int k, int depth) {
        for(int i=0;i<dungenos.length;i++) {
            if(!visited[i] && k >= dungenos[i][0]) {
                visited[i]=true;
                dfs(dungenos, k-dungenos[i][1], depth+1);
                visited[i]=false;
            }
        }
        answer = Math.max(answer, depth);
    }

    @Test
    public void test() {
        Assert.assertEquals(3, solution(80, new int[][]{{80,20},{50,40},{30,10}}));
    }
}
