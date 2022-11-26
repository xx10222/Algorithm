package programmers;

import org.junit.Test;

import java.util.Arrays;

public class 숫자타자대회 {
    public int solution(String numbers) {
        // 다시 누르기 - 1
        // 상하좌우 - 2
        // 대각선 - 3
        // 인접하지 않으면 최소 가중치로 이동
        // 시작 - 4, 6
        // 가중치 미리 계산해두기
        int[][] cost = {
                { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
                { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
                { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
                { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
                { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
                { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
                { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
                { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
                { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
                { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }
        };

        int answer = 0;
        String[] list = numbers.split("");
        int left = 4;
        int right = 6;
        for(String s : list) {
            int dest = Integer.parseInt(s);
            int l = cost[left][dest];
            int r = cost[right][dest];
            if(l<=r) {
                answer += l;
                left = dest;
            } else {
                answer += r;
                right = dest;
            }
        }
        return answer;
    }


}
