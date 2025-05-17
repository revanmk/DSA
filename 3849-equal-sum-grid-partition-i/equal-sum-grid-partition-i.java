class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        long total_sum=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                total_sum+=grid[i][j];
            }
        }
        if(total_sum%2!=0)
            return false;
        long rowPrefixSum = 0;
        for (int i = 0; i < rows - 1; i++) { // must be a strict partition
            for (int j = 0; j < cols; j++) {
                rowPrefixSum += grid[i][j];
            }
            if (rowPrefixSum == total_sum / 2) return true;
        }
        int colSum[]=new int[cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                colSum[j]+=grid[i][j];
            }
        }
            long colPrefixSum = 0;
                for (int j = 0; j <cols-1; j++) {
                    colPrefixSum += colSum[j];
                    if (colPrefixSum == total_sum / 2) return true;

            }
        return false;
        
    }
}