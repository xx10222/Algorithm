package programmers;

public class HashadNumber {
    public boolean solution(int x) {
        int sum = 0;
        String[] s = (Integer.toString(x)).split("");
        for(int i=0;i<s.length;i++) {
            sum += Integer.parseInt(s[i]);
        }
        if(x % sum == 0) {
            return true;
        }
        return false;
    }
}
