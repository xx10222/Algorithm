package programmers;

public class MinRectangular {
    public int solution(int[][] sizes) {
        int row = 0;
        int col = 0;
        for(int i=0;i<sizes.length;i++) {
            // 가로, 세로 길이 중 긴 길이가 가로 길이가 된다 (=row)
            int a = Math.max(sizes[i][0], sizes[i][1]);
            int b = Math.min(sizes[i][0], sizes[i][1]);

            row = Math.max(row, a);
            col = Math.max(col, b);
        }
        return row * col;
    }
}
