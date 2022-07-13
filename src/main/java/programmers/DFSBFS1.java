package programmers;

public class DFSBFS1 {
    static int answer = 0;
    public static void main(String[] args) {
        int[] numbers = {4,1,2,1};
        int target = 4;
        System.out.println(solution(numbers, target));

    }
    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    public static void dfs(int[] numbers, int target, int depth, int sum) {
        if(numbers.length == depth) { //마지막 노드 탐색
            if(sum==target) {
                answer++;
            }
        } else {
            dfs(numbers, target, depth+1, sum+numbers[depth]);
            dfs(numbers, target, depth+1, sum-numbers[depth]);
        }
    }
}
