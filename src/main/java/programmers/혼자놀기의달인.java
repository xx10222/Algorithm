package programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 혼자놀기의달인 {
    static boolean[] visit;
    static int depth;

    public int solution(int[] cards) {
        int answer = 1;
        int len = cards.length;
        visit = new boolean[len+1];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<len;i++) {
            if(!visit[i+1]) {
                depth = 1;
                visit[i+1] = true;
                open(cards[i], cards);
                list.add(depth);
            }
        }
        if(list.size()<2) {
            return 0;
        }
        Collections.sort(list, Collections.reverseOrder());
        answer = list.get(0) * list.get(1);
        return answer;
    }

    private static void open(int x, int[] cards) {
        if(!visit[x]) {
            visit[x] = true;
            depth += 1;
            open(cards[x-1], cards);
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(12, solution(new int[] {8,6,3,7,2,5,1,4}));
    }
}
