import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> box = new HashSet<>();
            
            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != '.') {
                    if (!rows.add(board[i][j])) return false;
                }
                
                // Check column
                if (board[j][i] != '.') {
                    if (!cols.add(board[j][i])) return false;
                }

                // Check 3x3 box
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                char boxVal = board[rowIndex + j / 3][colIndex + j % 3];
                if (boxVal != '.') {
                    if (!box.add(boxVal)) return false;
                }
            }
        }
        return true;
    }
}
