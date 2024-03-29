package programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class CrainDollPeek {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int move : moves) {
            for(int i=0;i<board.length;i++) {
                int doll = board[i][move-1];
                if(doll==0) {
                    continue;
                }
                board[i][move-1]=0;
                if(!stack.isEmpty() && stack.peek()==doll) {
                    answer += 2;
                    stack.pop();
                    break;
                }
                stack.push(doll);
                break;
            }

        }
        return answer;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, solution(
                new int [][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}},
                new int[] {1,5,3,5,1,2,1,4}
                )
        );
        Assert.assertEquals(8, solution(new int[][]{{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3}}, new int[]{1,5,3,5,1,2,1,4}));
        Assert.assertEquals(0, solution(new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}}, new int[]{1,5,3,5,1,2,1,4}));
    }
}
