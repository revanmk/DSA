class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        int rows=board.length;
        int cols=board[0].length;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(board[i][j]=='.'){
                    for(char num='1';num<='9';num++)
                    {
                        if(isOk(num,board,i,j)){
                            board[i][j]=num;
                        if(solve(board)==true)
                            return true;
                        else
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isOk(char num,char[][] board,int row,int col){
        for(int i=0;i<9;i++){
            if(board[row][i]== num)
                return false;
            if(board[i][col]==num)
                return false;
            int subgridRow = 3 * (row / 3) + i / 3;
            int subgridCol = 3 * (col / 3) + i % 3;
        if (board[subgridRow][subgridCol] == num) return false;
        }
        return true;
    }
}