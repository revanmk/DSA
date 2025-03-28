class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return(compute(nums,goal)-compute(nums,goal-1));
    }
    public static int compute(int nums[],int goal){
        int l=0,r=0,cnt=0,sum=0;
        if(goal<0)
            return 0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>goal)
            {
                sum-=nums[l];
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
        return cnt;
    }
}