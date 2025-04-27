class Solution {
    public int countSubarrays(int[] nums) {
        int left=0;
        int end=2;
        int count=0;
        while(end<nums.length)
        {
            if((nums[left]+nums[end])*2==nums[end-1])
                count++;
            left++;
            end++;
        }
        return count;
    }
}