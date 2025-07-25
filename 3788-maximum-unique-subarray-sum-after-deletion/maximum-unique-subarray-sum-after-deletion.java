class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
            max=Math.max(max,nums[i]);
        }
        if(max<0){
            return max;
        }
        int sum=0;
        int ans=nums[0];
        for(int i:set){
            if(i<0){
                continue;
            }
            sum+=i;
        }
        return sum;
    }
}