class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return getSubArrayCount(nums,k)-getSubArrayCount(nums,k-1);
    }
    public static int getSubArrayCount(int nums[],int k){
        int left=0,right=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        int count=0;
        while(right<len){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            if(map.get(nums[right])==1){
                k--;
            }
            while(k<0){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    k++;
                }
                left++;
            }
            count+=(right-left+1);
            right++;
        }
        return count;
    }
}