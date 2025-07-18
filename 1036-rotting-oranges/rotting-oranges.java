class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        if(rows==0 || grid==null)
            return -1;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]==2)
                    dfs(grid,i,j,2);
            }
        }
        int minutes=2;
        for(int[] row: grid){
            for(int cell:row){
                if(cell==1)
                    return -1;
                minutes=Math.max(minutes,cell);
            }
        }
        return minutes-2;
    }
    public void dfs(int[][] grid,int row,int col,int minutes){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length|| grid[row][col]==0||(grid[row][col]>1 && grid[row][col]<minutes))
            return;
        else{
            grid[row][col]=minutes;
            dfs(grid,row-1,col,minutes+1);
            dfs(grid,row+1,col,minutes+1);
            dfs(grid,row,col-1,minutes+1);
            dfs(grid,row,col+1,minutes+1);

        }
    }
}