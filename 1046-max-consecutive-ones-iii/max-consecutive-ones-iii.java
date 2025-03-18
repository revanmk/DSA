class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxlen=0;
        int left=0;
        int right=0;
        int zeroes=0;
        int len;
        while(right<nums.length)
        {
            if(nums[right]==0)
                zeroes++;
            if(zeroes>k)
            {
                if(nums[left]==0)
                    zeroes--;
                left++;
            }
            if(zeroes<=k)
            {
                len=right-left+1;
                maxlen=Math.max(len,maxlen);
            }
            right++;
        }
        return maxlen;
    }
}