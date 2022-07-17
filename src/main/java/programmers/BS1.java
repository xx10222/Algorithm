package programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BS1 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 1;
        long end = (long)times[times.length-1] * n;

        while(start<=end) {
            long mid = (start+end)/2;
            long sum = 0;

            for (int time : times) {
                sum += mid / time;
            }

            if(sum >= n) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid+1;
            }
        }
        return answer;
    }

    @Test
    public void test() {
        Assert.assertEquals(28, solution(6, new int[] {7, 10}));
    }
}
