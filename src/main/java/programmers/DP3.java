package programmers;

import org.junit.Assert;
import org.junit.Test;

public class DP3 {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        int[][] arr = new int[n][m];

        for(int[] puddle : puddles) { // 웅덩이
            arr[puddle[1]-1][puddle[0]-1] = -1;
        }

        arr[0][0] = 1; // 출발점 초기화

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(arr[i][j]==-1) { // 웅덩이면 0으로 바꾸고 continue
                    arr[i][j] = 0;
                    continue;
                }

                if(i!=0) { // 위쪽 값 더해주기
                    arr[i][j] += arr[i-1][j] % mod;
                }

                if(j!=0) { // 왼쪽 값 더해주기
                    arr[i][j] += arr[i][j-1] % mod;
                }
            }
        }
        return arr[n-1][m-1] % mod;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, solution(4, 3, new int[][]{{2,2}}));
        Assert.assertEquals(7, solution(4, 4, new int[][]{{3,2}, {2,4}}));
        Assert.assertEquals(7, solution(5, 3, new int[][]{{4,2}}));
        Assert.assertEquals(0, solution(2, 2, new int[][]{{2,1}, {1, 2}}));
        Assert.assertEquals(0, solution(3, 1, new int[][]{{2,1}}));

    }
}
