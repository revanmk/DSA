class Solution {
    public int longestOnes(int[] nums, int k) {
       int maxlen=0;
       int len;
       for(int i=0;i<nums.length;i++)
       {
        int zeroes=0;
        for(int j=i;j<nums.length;j++){
            if(nums[j]==0)
                zeroes++;
            if(zeroes<=k)
            {
                len=j-i+1;
                maxlen=Math.max(maxlen,len);
            }
            else
                break;
        }
       }
        return maxlen;
        
    }
}