package programmers;

public class AddNonNumber {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] check = new boolean[10];
        for(int number : numbers) {
            if(!check[number]) {
                check[number] = true;
            }
        }

        for(int i=0;i<10;i++) {
            if(!check[i]) {
                answer += i;
            }
        }
        return answer;
    }
}
