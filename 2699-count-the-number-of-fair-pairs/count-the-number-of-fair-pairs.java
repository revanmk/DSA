class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long cnt=0;
        for(int i=0;i<nums.length;i++)
        {
            int a=leftBound(nums,i+1,nums.length-1,lower-nums[i]);
            int b=rightBound(nums,i+1,nums.length-1,upper-nums[i]);
            cnt+=(b-a+1);

        }
        return cnt;
    }
    public int leftBound(int nums[],int low,int high,int target){
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
             if(nums[mid]>=target)
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
    public int rightBound(int nums[],int low,int high,int target){
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]<=target)
                low=mid+1;
            else
                high=mid-1;
        }
        return high;
    }
}
//[0,1,4,4,5,7]