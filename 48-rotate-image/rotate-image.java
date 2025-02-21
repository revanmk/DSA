class Solution {
    public void rotate(int[][] matrix) {
       int matrix1[][]= new int[matrix.length][matrix.length];
        for(int i=0;i<matrix1.length;i++)
        {
            for(int j=0;j<matrix1.length;j++)
            {
                matrix1[i][j]=matrix[j][i];
            }
        }
    
    for(int j=0;j<matrix.length;j++)
      
        {
            for(int i=matrix.length-1;i>=0;i--)
            
            {
                matrix[j][i]=matrix1[j][matrix.length-i-1];
            }
        }
    }
}