import java.util.*;

class Solution {
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        ArrayList<String> board = new ArrayList<>();
        boolean[] rows = new boolean[n + 1];
        boolean[] diag1 = new boolean[2 * n + 1];
        boolean[] diag2 = new boolean[2 * n + 1];
        check(n, 1, board, rows, diag1, diag2);
        return ans;
    }

    public void check(int n, int j, ArrayList<String> board, boolean[] rows, boolean[] diag1, boolean[] diag2) {
        if (j > n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!rows[i] && !diag1[i + j] && !diag2[i - j + n]) {
                rows[i] = diag1[i + j] = diag2[i - j + n] = true;
                StringBuilder row = new StringBuilder();
                for (int k = 1; k <= n; k++) {
                    row.append(k == i ? 'Q' : '.');
                }

                board.add(row.toString());
                check(n, j + 1, board, rows, diag1, diag2);
                board.remove(board.size() - 1);

                rows[i] = diag1[i + j] = diag2[i - j + n] = false;
            }
        }
    }
}
