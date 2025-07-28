class Solution {
    public int partitionDisjoint(int[] nums) {
        int max=nums[0];
        int leftMax=nums[0];
        int idx=0;
        int n = nums.length;
        for(int i=1;i<n;i++){
            max=Math.max(max,nums[i]);
            if(nums[i]<leftMax){
                leftMax=max;
                idx=i;
            }
        }
        return idx+1;
    }
}