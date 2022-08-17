package programmers;

import org.junit.Assert;
import org.junit.Test;


public class WallCheck {
    int[] weak, dist;
    int[][] weak_cases;
    int n, answer;
    public int solution(int n, int[] weak, int[] dist) {
        weak_cases = new int[weak.length][weak.length];
        this.weak = weak;
        this.dist = dist;
        this.answer = dist.length+1;
        this.n = n;

        makeWeakCases();
        makeDistCases(new boolean[dist.length], new int[dist.length], 0);
        if(answer == dist.length+1)
            return -1;
        else
            return answer;
    }

    void makeWeakCases(){
        int[] weak_case = this.weak.clone();
        weak_cases[0] = weak_case.clone();
        for(int i = 1; i < weak.length; i++){
            int temp = weak_case[0];
            for(int j = 1; j < weak.length; j++){
                weak_case[j-1] = weak_case[j];
            }
            weak_case[weak.length-1] = temp+n;
            weak_cases[i] = weak_case.clone();
        }
    }

    void makeDistCases(boolean[] dist_visit, int[] dist_case, int idx){
        if(idx == dist.length){
            for(int[] weak_case: weak_cases)
                check(dist_case, weak_case);
        }
        for(int i = 0; i < dist.length; i++){
            if(!dist_visit[i]){
                dist_visit[i] = true;
                dist_case[idx] = dist[i];
                makeDistCases(dist_visit, dist_case, idx+1);
                dist_case[idx] = 0;
                dist_visit[i] = false;
            }
        }
    }

    void check(int[] dist_case, int[] weak_case){
        int cur = 0, next;
        int dist_idx = 0;
        while(cur < weak_case.length && dist_idx < dist_case.length){
            next = cur+1;
            while(next < weak_case.length &&
                    weak_case[cur] + dist_case[dist_idx] >= weak_case[next]){
                next++;
            }
            cur = next;
            dist_idx++;
        }

        if(cur == weak_case.length && dist_idx < answer)
            answer = dist_idx;
    }
    @Test
    public void test() {
        Assert.assertEquals(2, solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4}));
        Assert.assertEquals(1, solution(12, new int[]{1, 3, 4, 9, 10}, new int[]{3, 5, 7}));
        Assert.assertEquals(2, solution(200, new int[]{0, 100}, new int[]{1, 1}));
        Assert.assertEquals(3, solution(200, new int[]{0, 10, 50, 80, 120, 160}, new int[]{1, 10, 5, 40, 30}));
        Assert.assertEquals(1, solution(12, new int[]{0, 10}, new int[]{1, 2}));
        Assert.assertEquals(1, solution(12, new int[]{4}, new int[]{1, 2}));
        Assert.assertEquals(2, solution(30, new int[]{0, 3, 11, 21}, new int[]{10, 4}));
        Assert.assertEquals(-1, solution(200, new int[]{1, 3, 5, 7, 9, 11}, new int[]{1, 1, 1, 1, 1}));
        Assert.assertEquals(1, solution(19, new int[]{0, 10}, new int[]{9}));
    }
}
