class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max_difference=Math.abs(nums[0]-nums[1]);
        for(int i=1;i<nums.length-1;i++){
            max_difference=Math.max(max_difference,Math.abs(nums[i]-nums[i+1]));
        }
        return Math.max(max_difference,Math.abs(nums[0]-nums[nums.length-1]));
    }
}