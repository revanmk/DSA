class Solution {
    public int maxSum(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int sum=0;
        int ans=Integer.MIN_VALUE;
        for(int i:set){
            sum+=i;
            ans=Math.max(ans,sum);
            if(sum<0){
                sum=0;
            }
        }
        return ans;
    }
}