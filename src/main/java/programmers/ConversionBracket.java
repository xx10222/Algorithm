package programmers;

import org.junit.Assert;
import org.junit.Test;

public class ConversionBracket {
    public String solution(String p) {
        String answer = p;
        if(check(answer)) {
            return answer;
        }

        answer = split(answer);
        return answer;
    }

    // 올바른 문자열인지 판단하는 메소드
    private static boolean check(String s) {
        // 첫 문자가 ) 이면 올바르지 않은 문자열임
        if(s.charAt(0)==')') {
            return false;
        }

        int open = 1; // ( 의 개수

        for(int i=1;i<s.length();i++) {
            if(s.charAt(i)=='(') {
                open++;
            } else {
                open--;
                // (의 개수가 0보다 작으면 짝이 맞지 않으므로 올바르지 않은 문자열임
                if(open<0) {
                    return false;
                }
            }
        }
        // 위의 단계를 모두 통과하면 올바른 문자열임
        return true;
    }

    // u, v 분리 메소드
    private static String split(String s) {
        // 빈 문자열인 경우, 그대로 반환
        if(s.length()==0) {
            return s;
        }

        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        int open = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') {
                open++;
            } else {
                open--;
            }

            // 처음으로 '('의 개수가 0이 된 경우가 가장 작은 단위의 균형잡힌 문자열이다
            if(open==0) {
                // 현재 i를 기준으로 u와 v를 분리
                u.append(s, 0, i+1);
                v.append(s.substring(i+1));

                // u가 올바른 문자열인지 확인
                if(check(u.toString())) {
                    // v에 대해 재귀호출 후, u에 이어 붙인다
                    u.append(split(v.toString()));
                } else { // 4. u가 올바른 문자열이 아닌 경우
                    StringBuilder str = new StringBuilder();
                    str.append("(");
                    str.append(split(v.toString()));
                    str.append(")");
                    // u를 조작해서 붙인다
                    str.append(reverse(u.toString()));
                    return str.toString();
                }
                break;
            }
        }
        // u가 올바른 문자열인 경우 반환된다
        return u.toString();
    }

    // u 문자열을 변환하는 메소드
    private static String reverse(String u) {
        StringBuilder s = new StringBuilder();

        for(int i=1;i<u.length()-1;i++) {
            // 괄호를 뒤집어서 문자열에 붙여준다
            if(u.charAt(i)=='(') {
                s.append(")");
            } else {
                s.append("(");
            }
        }
        return s.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("(()())()", solution("(()())()"));
        Assert.assertEquals("()", solution(")("));
        Assert.assertEquals("()(())()", solution("()))((()"));
    }
}
