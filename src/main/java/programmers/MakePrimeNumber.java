package programmers;

import org.junit.Assert;
import org.junit.Test;

public class MakePrimeNumber {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                for(int k=j+1;k<nums.length;k++) {
                    int sum = nums[i]+nums[j]+nums[k];
                    if(isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public boolean isPrime(int num) { //에라토스테네스의 체
        for(int i=2;i<=Math.sqrt(num);i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, solution(new int[] {1,2,3,4}));
        Assert.assertEquals(4, solution(new int[] {1,2,7,6,4}));
    }
}
