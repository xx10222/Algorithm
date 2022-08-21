package programmers;

public class CollatzGuess {
    public int solution(int num) {
        long number = (long)num;
        int answer = 0;
        if(num==1) {
            return 0;
        }
        while(number!=1) {
            if(answer >= 500) {
                return -1;
            }
            answer++;
            if(number%2==0) {
                number /= 2;
            } else {
                number = number*3 + 1;
            }
        }
        return answer;
    }
}
