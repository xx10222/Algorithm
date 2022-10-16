package programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ncsoft1 {
    public String solution(String source) {
        StringBuilder sb = new StringBuilder();

        while(source.length()>0) {
            Set<Character> set = new HashSet<>();
            StringBuilder next = new StringBuilder();
            for(int i=0;i<source.length();i++) {
                if(!set.contains(source.charAt(i))) {
                    set.add(source.charAt(i));
                } else {
                    next.append(source.charAt(i));
                }
            }
            List<Character> list = new ArrayList<>(set);
            Collections.sort(list);
            for(int i=0;i<list.size();i++) {
                sb.append(list.get(i));
            }
            source=next.toString();
        }
        return sb.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("cetuxee", solution("execute"));
        Assert.assertEquals("bcemrucu", solution("cucumber"));
        Assert.assertEquals("abdabb", solution("bbaabd"));
    }
}
