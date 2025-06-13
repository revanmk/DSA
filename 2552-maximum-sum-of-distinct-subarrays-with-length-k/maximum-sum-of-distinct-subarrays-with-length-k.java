class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> set = new HashMap<>();
        long sum = 0;
        long maxSum = 0;
        maxSum = Math.max(maxSum, sum);
        int len = nums.length;
        int start=0;
        int end=0;

        while(end<len){
            int currNum=nums[end];
            int currFreq=set.getOrDefault(currNum,-1);

            while(start<=currFreq|| end-start+1>k){
                sum-=nums[start];
                start++;
            }
            set.put(currNum,end);
            sum+=nums[end];
            if(end-start+1==k){
                maxSum=Math.max(sum,maxSum);
            }
            end++;
        }

        return maxSum;
    }
}