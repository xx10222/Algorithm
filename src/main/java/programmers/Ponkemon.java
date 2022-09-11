package programmers;

import org.junit.Assert;
import org.junit.Test;

import java.beans.Transient;
import java.util.HashSet;
import java.util.Set;

public class Ponkemon {
    public int solution(int[] nums) {
        int num = nums.length/2;
        Set<Integer> set = new HashSet<>();

        for(int n : nums) {
            set.add(n);
        }

        if(set.size()<num) {
            return set.size();
        }
        return num;
    }

    @Test
    public void test() {
        Assert.assertEquals(2,solution(new int[] {3,1,2,3}));
        Assert.assertEquals(3,solution(new int[] {3,3,3,2,2,4}));
        Assert.assertEquals(2,solution(new int[] {3,3,3,2,2,2}));
    }

}
