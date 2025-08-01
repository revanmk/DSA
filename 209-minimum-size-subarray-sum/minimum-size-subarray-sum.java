class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (right < len) {
            sum += nums[right];
            while(sum >= target) 
            {
                ans = Math.min(ans, right - left+1);
                sum-=nums[left++];
            }
            right++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}