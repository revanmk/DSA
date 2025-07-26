// User function Template for Java

class Solution {
    int fun(int []arr,int ind,int []dp){
        if(ind == 0)
            return arr[0];
        if(ind < 0)
            return 0;
        if(dp[ind] != -1){
            return dp[ind];
        }
        int in = arr[ind] + fun(arr,ind-2,dp);
        int out = fun(arr,ind-1,dp);
        return dp[ind] = Math.max(in,out);
    }
    int findMaxSum(int arr[]) {
        int ind = arr.length-1;
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        fun(arr,ind,dp);
        return dp[ind];
    }
}