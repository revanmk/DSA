class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int vis[][] = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O' && vis[0][i] == 0)
                dfs(board, 0, i, vis);
            if (board[rows - 1][i] == 'O' && vis[rows - 1][i] == 0)
                dfs(board, rows - 1, i, vis);
        }
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O' && vis[i][0] == 0)
                dfs(board, i, 0, vis);
            if (board[i][cols - 1] == 'O' && vis[i][cols - 1] == 0)
                dfs(board, i, cols - 1, vis);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                    vis[i][j] = 1;
                }
            }
        }
    }

    void dfs(char[][] board, int i, int j, int[][] vis) {
        int rows = board.length;
        int cols = board[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] == 'X' || vis[i][j] == 1) {
            return;
        }
        vis[i][j] = 1;
        dfs(board, i + 1, j, vis);
        dfs(board, i - 1, j, vis);
        dfs(board, i, j - 1, vis);
        dfs(board, i, j + 1, vis);
    }
}