class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int vis[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count = Math.max(dfs(i, j, vis, grid, rows, cols), count);
                }
            }
        }
        return count;
    }

    public int dfs(int i, int j, int[][] vis, int[][] grid, int rows, int cols) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || vis[i][j] == 1 || grid[i][j] == 0)
            return 0;
        vis[i][j] = 1;
        return (1 + dfs(i + 1, j, vis, grid, rows, cols) + dfs(i - 1, j, vis, grid, rows, cols)
                + dfs(i, j + 1, vis, grid, rows, cols) + dfs(i, j - 1, vis, grid, rows, cols));
    }

}