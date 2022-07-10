package leetcode;

public class leet79 {
    static boolean[][] visited;
    static int row;
    static int col;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(dfs(i,j,0, word, board)) return true;
            }
        }

        return false;
    }

    public static boolean dfs(int x, int y, int index, String word, char[][] board) {
        if(word.length()==index) return true;

        if(x<0 || y<0 || x>=row || y>=col) return false;
        if(visited[x][y]) return false;
        if(word.charAt(index) != board[x][y]) return false;

        visited[x][y] = true;
        boolean result = dfs(x+dx[0], y+dy[0], index+1, word, board)
                || dfs(x+dx[1], y+dy[1], index+1, word, board)
                || dfs(x+dx[2], y+dy[2], index+1, word, board)
                || dfs(x+dx[3], y+dy[3], index+1, word, board);

        if(!result) {
            visited[x][y] = false;
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        exist(board, word);
    }
}
