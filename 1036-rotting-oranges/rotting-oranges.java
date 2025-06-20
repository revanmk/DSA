class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;
        if (q.isEmpty()) return -1;

        int abc= bfs(q,grid,fresh);
        return abc;
        
    }
    public static int bfs(Queue<Pair> q, int[][] grid, int fresh){
        int minutes = 0;
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rottedThisMinute = false;
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                for (int[] dir : dirs) {
                    int nx = p.x + dir[0];
                    int ny = p.y + dir[1];
                    if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        fresh--;
                        q.offer(new Pair(nx, ny));
                        rottedThisMinute = true;
                    }
                }
            }
            if (rottedThisMinute) minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
