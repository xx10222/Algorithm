package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class ReverseNumber {
    public long solution(long n) {
        long answer = 0;
        String[] s = (Long.toString(n)).split("");
        Arrays.sort(s, Comparator.reverseOrder());
        String str = "";
        for(String ss : s) {
            str += ss;
        }
        return Long.parseLong(str);
    }
}
