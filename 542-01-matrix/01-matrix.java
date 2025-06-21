class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int visited[][] = new int[rows][cols];
        int distance[][] = new int[rows][cols];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 1;
                } else {
                    visited[i][j] = 0;
                }
            }
        }

        int del_rows[] = { -1, 0, +1, 0 };
        int del_cols[] = { 0, +1, 0, -1 };

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int dist = p.dist;
            distance[row][col] = dist;

            for (int i = 0; i < 4; i++) {
                int nrow = row + del_rows[i];
                int ncol = col + del_cols[i];
                if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && visited[nrow][ncol] == 0) {
                    visited[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol, dist + 1));
                }
            }
        }
        return distance;
    }
}

class Pair {
    int row;
    int col;
    int dist;

    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}