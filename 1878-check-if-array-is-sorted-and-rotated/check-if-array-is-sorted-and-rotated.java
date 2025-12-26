class Solution {
    public boolean check(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        for(int i=0;i<len-1;i++){
            if(nums[i]>nums[i+1]){
                cnt++;
            }
        }
        if(nums[len-1]>nums[0]){
            cnt++;
        }
        return cnt<2;
    }
}