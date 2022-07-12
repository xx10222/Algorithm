package programmers;

public class DP2 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }
    public static int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;

        for(int i=1;i<n;i++) {
            for(int j=0;j<=i;j++) {
                int temp = triangle[i][j];
                if(j==0) {
                    temp += triangle[i-1][j];
                }
                else if(i==j) {
                    temp += triangle[i-1][j-1];
                } else {
                    temp += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
                triangle[i][j] = temp;
            }
        }
        for(int i=1;i<n;i++) {
            if(answer<triangle[n-1][i]) {
                answer = triangle[n-1][i];
            }
        }
        return answer;
    }
}
