package programmers;

import org.junit.Assert;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 할인행사 {
    public static void main(String[] args) {
        Assert.assertEquals(3, solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));

        Assert.assertEquals(0, solution(new String[]{"apple"},
                new int[]{10},
                new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i=0;i<want.length;i++) {
            wantMap.put(want[i], number[i]);
        }

        for(int i=0;i<= discount.length-10;i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for(int j=i;j<i+10;j++) {
                String key = discount[j];
                if(discountMap.containsKey(key)) {
                    discountMap.replace(key, discountMap.get(key)+1);
                    continue;
                }
                discountMap.put(key, 1);
            }


            Iterator<String> keys = wantMap.keySet().iterator();
            boolean check = false;
            while( keys.hasNext() ){
                String key = keys.next();
                if(!discountMap.containsKey(key) || discountMap.get(key) != wantMap.get(key)) {
                    check = true;
                    break;
                }
            }

            if(!check) {
                answer++;
//                 System.out.println(i);

//                 Set<String> keySet1 = wantMap.keySet();
//                 for (String key : keySet1) {
//                     System.out.println(key + " : " + wantMap.get(key));
//                 }
//                 System.out.println();
//                 Set<String> keySet = discountMap.keySet();
//                 for (String key : keySet) {
//                     System.out.println(key + " : " + discountMap.get(key));
//                 }
//                 System.out.println("===============");

                continue;
            }


        }

        return answer;
    }
}
