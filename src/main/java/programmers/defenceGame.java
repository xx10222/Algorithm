package programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

public class defenceGame {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);

            if(n<0) {
                if(k>0) {
                    n += pq.poll();
                    k--;
                    continue;
                }
                answer = i;
                break;
            }
        }
        return answer;
    }

    @Test
    public void test() {
        Assert.assertEquals(5, solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
        Assert.assertEquals(4, solution(2, 4, new int[]{3, 3, 3, 3}));
    }
}
