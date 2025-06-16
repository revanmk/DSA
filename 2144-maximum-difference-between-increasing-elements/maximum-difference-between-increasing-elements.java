class Solution {
    public int maximumDifference(int[] nums) {
        int ans=-1;
        int present_min=nums[0];
        int len=nums.length;
        for(int i=1;i<len;i++)
        {
            if(nums[i]>present_min){
                ans=Math.max(ans,nums[i]-present_min);
            }
            else{
                present_min=nums[i];
            }
        }
        return ans;
    }
}