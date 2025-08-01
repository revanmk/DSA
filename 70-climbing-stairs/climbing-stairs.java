class Solution {
    public int climbStairs(int n) {
        if(n<=1){
            return 1;
        }
        int dp[] = new int[46];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<46;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}