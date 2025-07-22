class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        return bfs(grid, 0, 0);
    }

    public static int bfs(int[][] grid, int i, int j) {
        if (grid[i][j] == 1) {
            return -1;
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        int dist = 1;
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        while (!q.isEmpty()) {
            int s = q.size();
            for (int ia = 0; ia < s; ia++) {
                Pair p = q.poll();
                int a = p.i;
                int b = p.j;
                if (a == grid.length - 1 && b == grid[0].length - 1) {
                    return dist;
                }
                if (a + 1 < grid.length && !vis[a + 1][b] && grid[a + 1][b] == 0) {
                    vis[a + 1][b] = true;
                    q.offer(new Pair(a + 1, b));
                }
                if (a - 1 >= 0 && !vis[a - 1][b] && grid[a - 1][b] == 0) {
                    vis[a - 1][b] = true;
                    q.offer(new Pair(a - 1, b));
                }
                if (b + 1 < grid[0].length && !vis[a][b + 1] && grid[a][b + 1] == 0) {
                    vis[a][b + 1] = true;
                    q.offer(new Pair(a, b + 1));
                }
                if (b - 1 >= 0 && !vis[a][b - 1] && grid[a][b - 1] == 0) {
                    vis[a][b - 1] = true;
                    q.offer(new Pair(a, b - 1));
                }
                if (a + 1 < grid.length && b + 1 < grid[0].length && !vis[a + 1][b + 1] && grid[a + 1][b + 1] == 0) {
                    vis[a + 1][b + 1] = true;
                    q.offer(new Pair(a + 1, b + 1));
                }
                if (a + 1 < grid.length && b - 1 >= 0 && !vis[a + 1][b - 1] && grid[a + 1][b - 1] == 0) {
                    vis[a + 1][b - 1] = true;
                    q.offer(new Pair(a + 1, b - 1));
                }
                if (a - 1 >= 0 && b + 1 < grid[0].length && !vis[a - 1][b + 1] && grid[a - 1][b + 1] == 0) {
                    vis[a - 1][b + 1] = true;
                    q.offer(new Pair(a - 1, b + 1));
                }
                if (a - 1 >= 0 && b - 1 >= 0 && !vis[a - 1][b - 1] && grid[a - 1][b - 1] == 0) {
                    vis[a - 1][b - 1] = true;
                    q.offer(new Pair(a - 1, b - 1));
                }
            }
            dist++;

        }
        return -1;
    }
}

class Pair {
    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}