class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        int ans=-1;
        while(low<=high){
            int mid = (low+high)>>1;
            if(countLessOrEqual(mid,matrix,n)>=k){
                ans=mid;
                high=mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static int countLessOrEqual(int mid, int[][] matrix,int n){
        int count=0;
        int c=n-1;
        for(int r=0;r<n;r++)
        {
            while(c>=0 && matrix[r][c]>mid){
                c--;
            }
            count+=(c+1);
        }
        return count;
    }
}