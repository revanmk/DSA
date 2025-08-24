class Solution {
    public int maxSubArray(int[] nums) {
        int ans = 0;
        int maxSum=Integer.MIN_VALUE;
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        for(int i=0;i<len;i++){
            ans+=nums[i];
            maxSum = Math.max(ans,maxSum);
            if(ans<0){
                ans = 0;
            }
        }
        return maxSum;
    }
}