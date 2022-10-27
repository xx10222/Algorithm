package programmers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PickUpItem {
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // characterX, characterY : 출발 위치
        // itemX, itemY : 도착 위치

        int answer = 0;
        // 길 사이마다 빈 공간을 넣어서 길을 쉽게 찾도록 좌표를 2배로 키워준다
        int startX = characterX*2;
        int startY = characterY*2;
        int endX = itemX*2;
        int endY = itemY*2;

        boolean[][] map = new boolean[103][103];

        // 테두리 포함해서 직사각형 내부에 true로 변경
        for(int[] rec : rectangle) {
            for(int i = rec[0]*2;i<=rec[2]*2;i++) {
                for(int j=rec[1]*2;j<=rec[3]*2;j++) {
                    map[i][j] = true;
                }
            }
        }

        // 테두리 제외해서 직사각형 내부에 false로 변경
        for(int[] rec : rectangle) {
            for(int i = rec[0]*2+1;i<rec[2]*2;i++) {
                for(int j=rec[1]*2+1 ;j<rec[3]*2;j++) {
                    map[i][j] = false;
                }
            }
        }

        // bfs로 탐색
        Stack<Point> stack = new Stack<>();

        //시작점 설정
        Point p = new Point(startX, startY);
        stack.add(p);

        List<Integer> result = new ArrayList<>();
        int cnt = 0;

        while(true) {
            if(stack.isEmpty()) {
                result.add(cnt);
                break;
            }
            Point temp = stack.pop();
            int x = temp.x;
            int y = temp.y;

            //도착하면 갯수 저장
            if(x==endX && y==endY) {
                result.add(cnt);
            }

            // 지났으면 지난자리 false
            map[x][y] = false;

            if(map[x][y+1]) {
                stack.add(new Point(x,y+1));
            }
            if(map[x][y-1]) {
                stack.add(new Point(x,y-1));
            }
            if(map[x+1][y]) {
                stack.add(new Point(x+1,y));
            }
            if(map[x-1][y]) {
                stack.add(new Point(x-1,y));
            }

            cnt++;
        }

        answer = Math.min(result.get(0)/2, result.get(1)/2 - result.get(0)/2);
        return answer;
    }


    @Test
    public void test() {
//        Assert.assertEquals();
    }
}
