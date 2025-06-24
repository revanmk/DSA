class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int vis[][] = new int[rows][cols];
        for(int i=0;i<cols;i++)
        {
            if(grid[0][i]==1 && vis[0][i]==0){
                dfs(grid,vis,0,i);
            }
            if(grid[rows-1][i]==1 && vis[rows-1][i]==0){
                dfs(grid,vis,rows-1,i);
            }
        }
        for(int i=0;i<rows;i++)
        {
            if(grid[i][0]==1 && vis[i][0]==0){
                dfs(grid,vis,i,0);
            }
            if(grid[i][cols-1]==1 && vis[i][cols-1]==0){
                dfs(grid,vis,i,cols-1);
            }
        }
        int count=0;

        for(int i=1;i<rows-1;i++)
        {
            for(int j=1;j<cols-1;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int[][] grid, int[][] vis, int row, int col){

        int rows=grid.length;
        int cols=grid[0].length;
        vis[row][col]=1;
        int del_rows[]={-1,0,+1,0};
        int del_cols[]={0,+1,0,-1};

        for(int i=0;i<4;i++)
        {
            int nrow=row+del_rows[i];
            int ncol=col+del_cols[i];

            if(nrow>=0 && nrow<rows && ncol>=0 && ncol<cols && vis[nrow][ncol]==0 && grid[nrow][ncol]==1)
                dfs(grid,vis,nrow,ncol);
        }
    }
}