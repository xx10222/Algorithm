package programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works) {
            pq.offer(work);
        }
        for(int i=0;i<n;i++) {
            int max = pq.poll();
            if(max<=0) {
                break;
            }
            pq.offer(max-1);
        }

        while(!pq.isEmpty()) {
            int p = pq.poll();
            answer += (p*p);
        }
        return answer;
    }

    @Test
    public void test() {
        Assert.assertEquals(12, solution(4, new int[] {4,3,3}));
        Assert.assertEquals(6, solution(1, new int[] {2,1,2}));
        Assert.assertEquals(0, solution(3, new int[] {1,1}));
    }
}
