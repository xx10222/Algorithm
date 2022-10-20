package programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LinkIsland {
    static int[] parent;
    public int solution(int n, int[][] costs) { // 크루스칼 알고리즘 사용
        int answer = 0;
        parent = new int[n];
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2])); // 건설 비용 기준으로 오름차순 정렬
        for(int i=0;i<n;i++) { //union set 초기화
            parent[i] = i;
        }

        for(int[] cost : costs) {
            if(find(cost[0]) != find(cost[1])) {
                answer += cost[2];
                union(cost[0], cost[1]);
            }
        }

        return answer;
    }

    private static int find(int x) { // 부모노드 탐색 연산
        if(parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

    private static void union(int x, int y) { // 부모 노드 합집합 연산
        x = find(x);
        y = find(y);
        if(x>y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(4, solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
        Assert.assertEquals(159, solution(7, new int[][] {{2,3,7},{3,6,13},{3,5,23},{5,6,25},{0,1,29},{1,5,34},{1,2,35},{4,5,53},{0,4,75}}));
    }
}
