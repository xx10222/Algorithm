package programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ncsoft2 {
    static Map<Integer, List<Integer>> map;
    static int distance;
    static Set<Integer> set;
    public int solution(int[] music) {
        map = new HashMap<>();
        map.put(1, new ArrayList<>(Arrays.asList(2,3)));
        map.put(2, new ArrayList<>(Arrays.asList(1,3)));
        map.put(3, new ArrayList<>(Arrays.asList(1,2,4,5)));
        map.put(4, new ArrayList<>(Arrays.asList(3,5)));
        map.put(5, new ArrayList<>(Arrays.asList(3,4,6,7)));
        map.put(6, new ArrayList<>(Arrays.asList(5,7)));
        map.put(7, new ArrayList<>(Arrays.asList(5,6,8,9)));
        map.put(8, new ArrayList<>(Arrays.asList(7,9,10)));
        map.put(9, new ArrayList<>(Arrays.asList(8,10)));
        map.put(10, new ArrayList<>(Arrays.asList(8,9,11,12)));
        map.put(11, new ArrayList<>(Arrays.asList(10,12)));
        map.put(12, new ArrayList<>(Arrays.asList(10,11)));

        int answer = 0;
        int start = 1;
        for(int i=0;i<music.length;i++) {
            distance=12;
            set = new HashSet<>(); // 방문처리
            move(start, music[i], 0);
            answer += distance;
            start = music[i];
        }
        return answer;
    }

    private static void move(int start, int end, int depth) {
        if(start==end) {
            if(distance>depth) {
                distance=depth;
                return;
            }
        }
        set.add(start);
        List<Integer> list = map.get(start); //list 원소 중 end랑 가장 가까운 원소로 이동
        int next = Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++) {
            int now = list.get(i);
            if(!set.contains(now) && Math.abs(next-end)>Math.abs(now-end)) {
                next = now;
            }
        }
        move(next, end, depth+1);
    }

    @Test
    public void test() {
        Assert.assertEquals(15, solution(new int[] {10,9,4,5,12}));
        Assert.assertEquals(13, solution(new int[] {6,4,2,11}));
    }
}
