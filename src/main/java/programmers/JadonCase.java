package programmers;

public class JadonCase {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.toLowerCase().split("");
        boolean space = true;
        for(String str : arr) {
            answer += space ? str.toUpperCase() : str;
            space = str.equals(" ") ? true : false;
        }
        return answer;
    }
}
