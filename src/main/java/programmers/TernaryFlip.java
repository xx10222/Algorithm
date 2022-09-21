package programmers;

import org.junit.Assert;
import org.junit.Test;


public class TernaryFlip {
    public int solution(int n) {
        String str = "";
        while(n>0) {
            str += (n%3);
            n/=3;
        }
        return Integer.parseInt(str, 3);
    }

    @Test
    public void test() {
        Assert.assertEquals(7, solution(45));
        Assert.assertEquals(229, solution(125));
    }
}
