package programmers;

import java.util.*;

public class 귤고르기 {
    static Map<Integer, Integer> map = new HashMap<>();
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, new comparator());

        for(int key : keys) {
            if(k <= 0) {
                break;
            }
            answer++;
            k -= map.get(key);
        }

        return answer;
    }

    public class comparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return map.get(o2).compareTo(map.get(o1));
        }
    }
}
